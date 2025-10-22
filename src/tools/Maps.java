
package tools;

import java.util.*;

public class Maps {
    public static final Map<String, List<String>> MAP_ESTADO_PARA_CIDADES = new HashMap<>();
    public static final Map<String, String> MAP_CIDADE_PARA_ESTADO = new HashMap<>();

    static {
        MAP_ESTADO_PARA_CIDADES.put("AC", Arrays.asList("Rio Branco", "Cruzeiro do Sul", "Sena Madureira", "Tarauacá", "Feijó", "Brasiléia", "Xapuri"));
        MAP_ESTADO_PARA_CIDADES.put("AL", Arrays.asList("Maceió", "Arapiraca", "Palmeira dos Índios", "Rio Largo", "Penedo", "União dos Palmares", "São Miguel dos Campos"));
        MAP_ESTADO_PARA_CIDADES.put("AP", Arrays.asList("Macapá", "Santana", "Laranjal do Jari", "Oiapoque", "Porto Grande", "Mazagão", "Tartarugalzinho"));
        MAP_ESTADO_PARA_CIDADES.put("AM", Arrays.asList("Manaus", "Parintins", "Itacoatiara", "Manacapuru", "Tabatinga", "Tefé", "Coari"));
        MAP_ESTADO_PARA_CIDADES.put("BA", Arrays.asList("Salvador", "Feira de Santana", "Vitória da Conquista", "Camaçari", "Itabuna", "Ilhéus", "Juazeiro"));
        MAP_ESTADO_PARA_CIDADES.put("CE", Arrays.asList("Fortaleza", "Juazeiro do Norte", "Sobral", "Crato", "Caucaia", "Maracanaú", "Itapipoca"));
        MAP_ESTADO_PARA_CIDADES.put("DF", Arrays.asList("Brasília", "Taguatinga", "Ceilândia", "Samambaia", "Sobradinho", "Planaltina", "Gama"));
        MAP_ESTADO_PARA_CIDADES.put("ES", Arrays.asList("Vitória", "Vila Velha", "Serra", "Cariacica", "Cachoeiro de Itapemirim", "Linhares", "Colatina"));
        MAP_ESTADO_PARA_CIDADES.put("GO", Arrays.asList("Goiânia", "Aparecida de Goiânia", "Anápolis", "Rio Verde", "Luziânia", "Águas Lindas de Goiás", "Trindade"));
        MAP_ESTADO_PARA_CIDADES.put("MA", Arrays.asList("São Luís", "Imperatriz", "Timon", "Caxias", "Codó", "Bacabal", "Santa Inês"));
        MAP_ESTADO_PARA_CIDADES.put("MT", Arrays.asList("Cuiabá", "Várzea Grande", "Rondonópolis", "Sinop", "Tangará da Serra", "Lucas do Rio Verde", "Sorriso"));
        MAP_ESTADO_PARA_CIDADES.put("MS", Arrays.asList("Campo Grande", "Dourados", "Três Lagoas", "Corumbá", "Ponta Porã", "Naviraí", "Paranaíba"));
        MAP_ESTADO_PARA_CIDADES.put("MG", Arrays.asList("Belo Horizonte", "Uberlândia", "Contagem", "Juiz de Fora", "Betim", "Montes Claros", "Uberaba"));
        MAP_ESTADO_PARA_CIDADES.put("PA", Arrays.asList("Belém", "Ananindeua", "Santarém", "Marabá", "Parauapebas", "Castanhal", "Cametá"));
        MAP_ESTADO_PARA_CIDADES.put("PB", Arrays.asList("João Pessoa", "Campina Grande", "Santa Rita", "Patos", "Bayeux", "Sousa", "Guarabira"));
        MAP_ESTADO_PARA_CIDADES.put("PR", Arrays.asList("Curitiba", "Londrina", "Maringá", "Ponta Grossa", "Cascavel", "Foz do Iguaçu", "São José dos Pinhais"));
        MAP_ESTADO_PARA_CIDADES.put("PE", Arrays.asList("Recife", "Jaboatão dos Guararapes", "Olinda", "Caruaru", "Petrolina", "Paulista", "Cabo de Santo Agostinho"));
        MAP_ESTADO_PARA_CIDADES.put("PI", Arrays.asList("Teresina", "Parnaíba", "Picos", "Piripiri", "Floriano", "Campo Maior", "Barras"));
        MAP_ESTADO_PARA_CIDADES.put("RJ", Arrays.asList("Rio de Janeiro", "Niterói", "Duque de Caxias", "Nova Iguaçu", "São Gonçalo", "Belford Roxo", "São João de Meriti"));
        MAP_ESTADO_PARA_CIDADES.put("RN", Arrays.asList("Natal", "Mossoró", "Parnamirim", "São Gonçalo do Amarante", "Macau", "Ceará-Mirim", "Caicó"));
        MAP_ESTADO_PARA_CIDADES.put("RS", Arrays.asList("Porto Alegre", "Caxias do Sul", "Pelotas", "Canoas", "Santa Maria", "Gravataí", "Rio Grande"));
        MAP_ESTADO_PARA_CIDADES.put("RO", Arrays.asList("Porto Velho", "Ji-Paraná", "Ariquemes", "Vilhena", "Cacoal", "Jaru", "Rolim de Moura"));
        MAP_ESTADO_PARA_CIDADES.put("RR", Arrays.asList("Boa Vista", "Rorainópolis", "Caracaraí", "Mucajaí", "Pacaraima", "Cantá", "Iracema"));
        MAP_ESTADO_PARA_CIDADES.put("SC", Arrays.asList("Florianópolis", "Joinville", "Blumenau", "São José", "Criciúma", "Chapecó", "Itajaí"));
        MAP_ESTADO_PARA_CIDADES.put("SP", Arrays.asList("São Paulo", "Campinas", "Santos", "São Bernardo do Campo", "São José dos Campos", "Ribeirão Preto", "Sorocaba"));
        MAP_ESTADO_PARA_CIDADES.put("SE", Arrays.asList("Aracaju", "Nossa Senhora do Socorro", "Lagarto", "Itabaiana", "Estância", "São Cristóvão", "Simão Dias"));
        MAP_ESTADO_PARA_CIDADES.put("TO", Arrays.asList("Palmas", "Araguaína", "Gurupi", "Porto Nacional", "Paraíso do Tocantins", "Colinas do Tocantins", "Guaraí"));

        for (Map.Entry<String, List<String>> entry : MAP_ESTADO_PARA_CIDADES.entrySet()) {
            String estado = entry.getKey();
            for (String cidade : entry.getValue()) {
                MAP_CIDADE_PARA_ESTADO.put(cidade, estado);
            }
        }
    }
}
