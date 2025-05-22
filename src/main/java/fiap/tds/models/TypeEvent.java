package fiap.tds.models;

public enum TypeEvent {
    PORTAS_COM_PROBLEMAS ("Portas Com Problemas") , EMERGENCIA_MEDICA ("Emergência Médica"),
    FALHAS_TECNICAS ("Falhas Técnicas"), PROBLEMAS_NA_VIA("Problemas na Via"),
    OBJETO_PESSOAS_NA_VIA("Objeto/Pessoas Na Via"), ANOMALIA_NOS_FREIOS("Anomalia nos Freios"),
    FALHA_NA_COMUNICACAO_RADIOS("Falha Na Comunicação/Rádios"), ALERTA_DE_SEGURANCA("Alerta de Segurança");

    private final String descricao;

    TypeEvent(String descricao) {
        this.descricao = descricao;

    }
    public String getDescricao() {
        return descricao;
    }
    public static TypeEvent fromString(String valor) {
        if (valor == null) return null;
        String normalizado = valor.replace("-", "").replace(" ", "").toUpperCase();
        for (TypeEvent tipo : values()) {
            if (tipo.name().equals(normalizado)) return tipo;
        }
        throw new IllegalArgumentException("Tipo inválido: " + valor);
    }
}
