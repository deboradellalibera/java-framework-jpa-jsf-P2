package mbean.aula1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.aula1.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaBean {

    private String nome = "";
    private String telefone = "";
    private String endereco = "";
    private String aniversario = "";
    private String patrimonio = "";

    private ArrayList<Pessoa> pessoas;

    public PessoaBean() {
        pessoas = new ArrayList<>();
    }

    public boolean validaFormPessoa() {
        boolean retorno = true;
        if (nome.isEmpty()) {
            System.out.println("Nome é obrigatório");
            return false;
        }
        if (telefone.isEmpty()) {
            System.out.println("Telefone é obrigatório");
            return false;
        }
        if (endereco.isEmpty()) {
            System.out.println("Endereço é obrigatório");
            return false;
        }
        if (aniversario.isEmpty()) {
            System.out.println("Aniversário é obrigatório");
            return false;
        }
        if (patrimonio.isEmpty()) {
            System.out.println("Patrimônio é obrigatório");
            return false;
        }

        return retorno;
    }

    public void adicionarPessoa() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Pessoa pessoa = new Pessoa();

        if (validaFormPessoa()) {
            if (pessoas != null) {
                pessoa.setNome(nome);
                pessoa.setTelefone(telefone);
                pessoa.setEndereco(endereco);
                try {
                    pessoa.setAniversario(sdf.parse(aniversario));
                    pessoa.setPatrimonio(DecimalFormat.getInstance().parse(patrimonio).doubleValue());
                } catch (ParseException e) {
                    System.out.println("Erro ao converter data de aniversário" + e);
                }
            }
            pessoa.setId(Pessoa.idSource++);
            pessoas.add(pessoa);
        }
    }

    public void removerDadosPessoa(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
