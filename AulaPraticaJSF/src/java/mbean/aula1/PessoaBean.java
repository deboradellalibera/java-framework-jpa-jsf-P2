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

	private String nome = "Fulano";
	private String telefone = "99999-8888";
	private String endereco = "Rua tal";
	private String aniversario = "20/10/2000";
	private String patrimonio = "1.234.56";
	
	private ArrayList<Pessoa> pessoas;
	
	
	public PessoaBean(){
		pessoas = new ArrayList<Pessoa>();
	}
	
	public String adicionarPessoa(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setTelefone(telefone);
		pessoa.setEndereco(endereco);
		try{
			pessoa.setAniversario(sdf.parse(aniversario));

			pessoa.setPatrimonio(DecimalFormat.getInstance().parse(patrimonio).doubleValue());
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		pessoa.setId(Pessoa.idSource++);
		
		pessoas.add(pessoa);
		
		return null;
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
