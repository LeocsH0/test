package ReCicloBD.BDReCiclo.model;

public class Usuario {
    private int idUsuario;
    private double celular;
    private String email;
    private String nome;
    private String senha;
    private static final int MAX_COLETAS = 100;
    private Coleta[] coletas;
    private static final int MAX_RESIDUOS = 100;
    private Residuo[] residuos; 
    private boolean tipo; // false para coletor e true para produtor

    public Usuario(String nome, String senha, String senhaConfirmada, double celular, String email, boolean tipo){
        this.nome = nome;
        if (senhaConfirmada == senha){
            this.senha = senha;
        }
        this.celular = celular;
        this.email = email;
        this.tipo = tipo;
        }

    public Coleta realizarColeta(Coleta coleta){
        for (int i = 0; i < MAX_COLETAS; i++){
            if (coletas[i] == null && coleta.verificaDisponibilidade()){
                coletas[i] = coleta;
                return coletas[i];
            }
        }
        return null;
    }

    public Residuo cadastrarResiduo(Residuo residuo){
        if (tipo){
            for (int i = 0; i < MAX_RESIDUOS; i++){
                if (residuos[i] == null){
                    residuos[i] = residuo;
                    return residuos[i];
                }
            } 
        }
        return null;
    }

    private String dadosUsuario(){ // Obtem dados do usuarios para 

    }

    public String emitirDados(){ // Print de dados do usuario na tela
    
    }

    public String emitirRelatorio(){ // Para resíduos e coletas

    }





}
