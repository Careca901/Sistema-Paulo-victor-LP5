package bean;
// Generated 17/09/2025 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Produtos (Usado como COMPRA no seu sistema)
 */
@Entity
@Table(name="produtos", catalog="db_marcos_vilhanueva")
public class Produtos implements java.io.Serializable {

     private int idprodutos;
     // FALTAVA ISSO: Relacionamento com Clientes
     private Clientes clientes; 
     // FALTAVA ISSO: Relacionamento com Vendedor (Fornecedor)
     private Vendedor fornecedor; 
     
     private String nome;
     private double valorUnitario;
     private double valorTotal;
     private Integer grupo;
     private Set pedidosProdutoses = new HashSet(0);
     private String ativo;

    public Produtos() {
    }

    public Produtos(int idprodutos) {
        this.idprodutos = idprodutos;
    }
    
    // Construtor corrigido (faltava o parametro ativo e os relacionamentos)
    public Produtos(int idprodutos, Clientes clientes, Vendedor fornecedor, String nome, double valorUnitario, Integer grupo, Set pedidosProdutoses, String ativo) {
       this.idprodutos = idprodutos;
       this.clientes = clientes;
       this.fornecedor = fornecedor;
       this.nome = nome;
       this.valorUnitario = valorUnitario;
       this.grupo = grupo;
       this.pedidosProdutoses = pedidosProdutoses;
       this.ativo = ativo;
    }
   
    @Id 
    @Column(name="idprodutos", unique=true, nullable=false)
    public int getIdprodutos() {
        return this.idprodutos;
    }
    
    public void setIdprodutos(int idprodutos) {
        this.idprodutos = idprodutos;
    }

    // --- AQUI ESTÃO OS CAMPOS QUE FALTAVAM ---
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idclientes") // Verifique se no banco a coluna é idclientes
    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idvendedor") // Verifique se no banco a coluna é idvendedor
    public Vendedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Vendedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    // ------------------------------------------

    @Column(name="nome", length=60)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="valorUnitario", precision=10)
    public double getValorUnitario() {
        return this.valorUnitario;
    }
    
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Column(name="grupo")
    public Integer getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="produtos")
    public Set getPedidosProdutos() {
        return this.pedidosProdutoses;
    }
    
    public void setPedidosProdutos(Set pedidosProdutoses) {
        this.pedidosProdutoses = pedidosProdutoses;
    }
    
    @Column(name="ativo", length=1)
    public String getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    // Corrigido: Mapeie esta coluna se ela existir no banco
    @Column(name="valortotal", precision=10) 
    public double getTotal() {
        return this.valorTotal;
    }

    public void setTotal(double total) {
         // CORREÇÃO: Antes estava this.valorTotal = valorTotal (atribuindo a si mesmo)
         this.valorTotal = total;
    }
    
    // Importante para o ComboBox funcionar corretamente
    @Override
    public String toString() {
        return this.getNome(); // Ou retornar String.valueOf(idprodutos);
    }
}