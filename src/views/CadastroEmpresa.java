package views;

import Objetos.Empresa;
import cadastrobusca.Menu;
import cadastrobusca.objetos.Cliente;
import conexoes.MySQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author limal
 */
public class CadastroEmpresa extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    Empresa novoEmpresa = new Empresa ();

    /**
     * Creates new form lOJA
     */
    public CadastroEmpresa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        cbxEstado = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCadastroCadastrar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEndereco1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscaCNPJ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarCidade = new javax.swing.JTextField();
        txtEstado1 = new javax.swing.JLabel();
        btnBuscarBuscar = new javax.swing.JButton();
        bntBuscarLimpar = new javax.swing.JButton();
        txtBuscarEstado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        btnBuscarDeletar = new javax.swing.JButton();
        btnBuscarAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Cadastro de Cliente");

        jLabel2.setText("Razão Social");

        txtRazao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazaoActionPerformed(evt);
            }
        });

        jLabel3.setText("CNPJ");

        txtCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCNPJActionPerformed(evt);
            }
        });

        jLabel4.setText("Endereço");

        jLabel5.setText("Cidade");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        txtEstado.setText("Estado");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCadastroCadastrar1.setText("Voltar");
        btnCadastroCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroCadastrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastroCadastrar1)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(btnCadastroCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txtEndereco1.setColumns(20);
        txtEndereco1.setLineWrap(true);
        txtEndereco1.setRows(5);
        jScrollPane3.setViewportView(txtEndereco1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRazao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEstado, 0, 102, Short.MAX_VALUE))
                    .addComponent(txtCNPJ)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(149, 149, 149)
                                .addComponent(txtEstado))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Busca de Empresa");

        jLabel7.setText("CNPJ");

        txtBuscaCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaCNPJActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome");

        txtBuscarNome.setFocusable(false);
        txtBuscarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNomeActionPerformed(evt);
            }
        });

        jLabel9.setText("Endereço");

        jLabel10.setText("Cidade");

        txtBuscarCidade.setFocusable(false);
        txtBuscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCidadeActionPerformed(evt);
            }
        });

        txtEstado1.setText("Estado");

        btnBuscarBuscar.setText("Buscar");
        btnBuscarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBuscarActionPerformed(evt);
            }
        });

        bntBuscarLimpar.setText("Limpar");
        bntBuscarLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarLimparActionPerformed(evt);
            }
        });

        txtBuscarEstado.setFocusable(false);
        txtBuscarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEstadoActionPerformed(evt);
            }
        });

        txtEndereco.setColumns(20);
        txtEndereco.setLineWrap(true);
        txtEndereco.setRows(5);
        txtEndereco.setFocusable(false);
        jScrollPane1.setViewportView(txtEndereco);

        btnBuscarDeletar.setText("Deletar");
        btnBuscarDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeletarActionPerformed(evt);
            }
        });

        btnBuscarAtualizar.setText("Atualizar");
        btnBuscarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtBuscarNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBuscaCNPJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(bntBuscarLimpar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(338, 338, 338))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(btnBuscarAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEstado1)
                                        .addComponent(txtBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscarDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarBuscar)
                    .addComponent(bntBuscarLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEstado1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarDeletar)
                    .addComponent(btnBuscarAtualizar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    public void deletarEmpresa(Empresa novoEmpresa){
        this.conectar.conectaBanco();
        
        String consultaCNPJ = this.txtBuscaCNPJ.getText();
        
        try{
            var deletarCNPJ = "DELETE from cadastroclientes where cpf = '" + consultaCNPJ + "'";
                           
            this.conectar.updateSQL (deletarCNPJ);
            
        } catch (Exception e) {
            System.out.println("Erro ao Deletar Cliente"+ e.getMessage());
            JOptionPane.showMessageDialog (null, "Erro ao Deletar Cliente");
        }
    }
    
    public void atualizarEmpresa(Empresa novoEmpresa){
        this.conectar.conectaBanco();
        
        String consultaCNPJ = this.txtBuscaCNPJ.getText();
        
        try{
            var atualizaCNPJ = "UPDATE cadastroEmpresa SET "
                    + "nome = '" + txtBuscarNome.getText() + "', "
                    + "endereco = '" + txtEndereco.getText() + "', "
                    + "cidade = '" + txtBuscarCidade.getText()+ "', "
                    + "estado = '" + txtBuscarEstado.getText()+ "' "
                    + " WHERE "
                    + " cnpj = '" + consultaCNPJ + "';"
                    ;
            this.conectar.updateSQL (atualizaCNPJ);
                        
            if(novoEmpresa.getNome() == ""){
                JOptionPane.showMessageDialog(null, "Erro não Buscar Empresa");
            }         
        } catch(Exception e) {
            System.out.println("Erro ao Atualizar Empresa"+ e.getMessage());
            JOptionPane.showMessageDialog (null, "Erro ao buscar Empresa");
        
        } finally {
            txtBuscarNome.setText(novoEmpresa.getNome());
            txtEndereco.setText(novoEmpresa.getEndereco());
            txtBuscarCidade.setText(novoEmpresa.getCidade());
            txtBuscarEstado.setText(novoEmpresa.getEstado());
            
        }
    }
    
    private void buscarEmpresa(Empresa novoEmpresa){
       this.conectar.conectaBanco();
       String consultaCNPJ = this.txtBuscaCNPJ.getText ();
        
       try {
           var buscacpf =  "SELECT "
                   + "cpf,"
                   + "nome,"
                   + "endereco,"
                   + "cidade,"
                   + "estado"
                   + " FROM "
                   + "cadastroclientes"
                   + " WHERE "
                        + " CNPJ = '" + consultaCNPJ + "';"
                   ;
           
           this.conectar.executarSQL (buscacpf);
        
           while (this.conectar.getResultSet().next()) {
               novoEmpresa.setCNPJ(this.conectar.getResultSet().getString(1));
               novoEmpresa.setNome(this.conectar.getResultSet().getString(2));
               novoEmpresa.setEndereco(this.conectar.getResultSet().getString(3));
               novoEmpresa.setCidade(this.conectar.getResultSet().getString(4));
               novoEmpresa.setEstado(this.conectar.getResultSet().getString(5));
               
           }
           
           if (novoEmpresa.getCNPJ() == "") {
               JOptionPane.showMessageDialog(null, "Empresa não encontrado!");
           }
           
       } catch (Exception e) {
            System.out.println("Erro ao consultar Empresa " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Empresa");
            
        } finally {
           txtBuscaCNPJ.setText(novoEmpresa.getCNPJ());
           txtBuscarNome.setText(novoEmpresa.getNome());
           txtEndereco.setText(novoEmpresa.getEndereco());
           txtBuscarCidade.setText(novoEmpresa.getCidade());
           txtBuscarEstado.setText(novoEmpresa.getEstado());
           this.conectar.fechaBanco();
       }
    }
    
    private void CadastrarEmpresa(Empresa novo){
        this.conectar.conectaBanco(); //estabelecendo conexão com o bd
        
        novo.setNome(txtRazao.getText());
        novo.setCNPJ(txtCNPJ.getText());
        novo.setEndereco(txtEndereco1.getText());
        novo.setCidade(txtCidade.getText());
        novo.setEstado(String.valueOf(cbxEstado.getSelectedItem()));
        
        try{
            var query = "INSERT INTO `cadastroclientes`("
            + "nome,"
            + "cpf,"
            + "endereco,"
            + "cidade,"
            + "estado) values ("
            + "'" + novo.getNome () + "',"
            + "'" + novo.getCNPJ() + "',"
            + "'" + novo.getEndereco () + "',"
            + "'" + novo.getCidade () + "',"
            + "'" + novo.getEstado () + "'"
            + ");";
            
        this.conectar.insertSQL(query); 
           
            
        } catch (Exception e ) {
            System.out.println("Erro ao Cadastrar Cliente  " + e.getMessage());
            JOptionPane.showMessageDialog (null, "Erro ao Cadastrar Cliente!");
        } finally {
            this.conectar.fechaBanco ();
            JOptionPane.showMessageDialog (null, "Cadastro Realizado com Sucesso!!");
            
        }
    }
    
    private void txtRazaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazaoActionPerformed

    private void txtCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCNPJActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void txtBuscaCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaCNPJActionPerformed

    private void txtBuscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNomeActionPerformed

    private void txtBuscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCidadeActionPerformed

    private void btnBuscarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBuscarActionPerformed
        // TODO add your handling code here:
            buscarEmpresa(novoEmpresa);
    }//GEN-LAST:event_btnBuscarBuscarActionPerformed

    private void bntBuscarLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarLimparActionPerformed
        // TODO add your handling code here:
        novoEmpresa.LimpaEmpresa();
        this.txtBuscarNome.setText("");
        this.txtBuscaCNPJ.setText("");
        this.txtBuscarCidade.setText("");
        this.txtEndereco.setText("");
        this.txtBuscarEstado.setText("");
    }//GEN-LAST:event_bntBuscarLimparActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        novoEmpresa.LimpaEmpresa();
        this.txtRazao.setText("");
        this.txtCNPJ.setText("");
        this.txtCidade.setText("");
        this.txtEndereco1.setText("");
        this.cbxEstado.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtBuscarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEstadoActionPerformed

    private void btnBuscarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAtualizarActionPerformed
        // TODO add your handling code here:
        atualizarEmpresa(novoEmpresa);
        novoEmpresa.LimpaEmpresa();
        this.txtBuscarNome.setText("");
        this.txtBuscaCNPJ.setText("");
        this.txtBuscarCidade.setText("");
        this.txtEndereco.setText("");
        this.txtBuscarCidade.setText("");
        this.txtBuscarEstado.setText("");
        
    }//GEN-LAST:event_btnBuscarAtualizarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        CadastrarEmpresa(novoEmpresa);
        novoEmpresa.LimpaEmpresa();
        this.txtRazao.setText("");
        this.txtCNPJ.setText("");
        this.txtCidade.setText("");
        this.txtEndereco1.setText("");
        this.cbxEstado.setSelectedIndex(0);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnBuscarDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDeletarActionPerformed
        // TODO add your handling code here:
        deletarEmpresa(novoEmpresa);
        novoEmpresa.LimpaEmpresa();
        this.txtBuscarNome.setText("");
        this.txtBuscaCNPJ.setText("");
        this.txtBuscarCidade.setText("");
        this.txtEndereco.setText("");
        this.txtBuscarCidade.setText("");
        this.txtBuscarEstado.setText("");
        LimpaC
        
    }//GEN-LAST:event_btnBuscarDeletarActionPerformed

    private void btnCadastroCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroCadastrar1ActionPerformed
        new Menu().setVisible(true);
        CadastroEmpresa.this.dispose();
    }//GEN-LAST:event_btnCadastroCadastrar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscarLimpar;
    private javax.swing.JButton btnBuscarAtualizar;
    private javax.swing.JButton btnBuscarBuscar;
    private javax.swing.JButton btnBuscarDeletar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCadastroCadastrar1;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtBuscaCNPJ;
    private javax.swing.JTextField txtBuscarCidade;
    private javax.swing.JTextField txtBuscarEstado;
    private javax.swing.JTextField txtBuscarNome;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JTextArea txtEndereco1;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JTextField txtRazao;
    // End of variables declaration//GEN-END:variables
}