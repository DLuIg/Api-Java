package fiap.tds.infrastructure;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty; // Para injetar propriedades do application.properties
import jakarta.inject.Inject;

@Provider // Anotação JAX-RS para registrar este filtro automaticamente
public class MyApiFilter implements ContainerRequestFilter {

    // Injeta a chave API configurada no application.properties
    @ConfigProperty(name = "api.key")
    String apiKey;

    // Opcional: Injetar outra chave se necessário
    @ConfigProperty(name = "api.key.mobile", defaultValue = "fallback_key")
    String apiKeyMobile; // Exemplo com valor default

    private static final String API_KEY_HEADER = "X-API-Key";

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Obtém o valor do cabeçalho X-API-Key da requisição
        String providedApiKey = requestContext.getHeaderString(API_KEY_HEADER);

        // Log para debug (útil durante o desenvolvimento)
        System.out.println("Received API Key: " + providedApiKey);
        System.out.println("Expected API Key: " + apiKey);

        // Verifica se a chave fornecida corresponde à chave esperada
        // Considere usar um mecanismo mais seguro para comparação de chaves em produção para evitar timing attacks
        if (providedApiKey == null || (!providedApiKey.equals(apiKey) && !providedApiKey.equals(apiKeyMobile))) {
            // Se a chave não for válida, aborta a requisição e retorna 401 Unauthorized
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("API Key inválida ou ausente.")
                            .build());
            // Opcional: Logar a tentativa de acesso não autorizado
            System.err.println("Unauthorized access attempt with key: " + providedApiKey);
        }
        // Se a chave for válida, a requisição continua para o recurso de destino
    }
}