/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import classes.Servico;
import conexoes.MySQL;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Rosimeire
 */
public class BuscarServiço extends javax.swing.JFrame {

    Servico novo = new Servico();
    MySQL conectar = new MySQL();
    public BuscarServiço() {
        initComponents();
    }
    Vector<Integer> id_trabalho = new Vector<Integer>();
    Vector<Integer> id_prestador = new Vector<Integer>();
    Vector<Integer> id_empresa = new Vector<Integer>();
    
    private void DeletarServico(){
    this.conectar.conectaBanco();
        try{
           var query = "DELETE from Servico where idServico = '" + txtBuscaServico.getText() + "'";
           
           this.conectar.updateSQL(query);
           
    
        }catch(Exception erro){
            System.out.println("Erro ao deletar serviço: " + erro);
        }
    }
    private void limparCampos(){
        txtBuscaServico.setText("");
        txtBuscarCPF.setText("");
        txtBuscarCidade.setText("");
        txtBuscarEstado.setText("");
        txtDescricao.setText("");
        txtEndereco.setText("");
        txt_data.setText("");
        txt_horario.setText("");
        
        cbxEmpresa.setModel(new DefaultComboBoxModel());
       cbxPrestador.setModel(new DefaultComboBoxModel());
       cbxServico.setModel(new DefaultComboBoxModel());
    }
    private void atualizarServico(){
        novo.setIdServico(id_trabalho.get(cbxServico.getSelectedIndex()));
        novo.setIdPrestador( id_prestador.get(cbxPrestador.getSelectedIndex()));
        novo.setIdEmpresa( id_empresa.get(cbxEmpresa.getSelectedIndex()));
        novo.setEndereco(txtEndereco.getText());
        novo.setCidade(txtBuscarCidade.getText());
        novo.setEstado(txtBuscarEstado.getText());
        novo.setData(txt_data.getText());
        novo.setHorario(txt_horario.getText());
        novo.setDescricao(txtDescricao.getText());
        novo.setCpfCliente(Integer.parseInt(txtBuscarCPF.getText()));
        txtDescricao.setFocusable(true);
        
        this.conectar.conectaBanco();
        
        /*idServico int primary key auto_increment, -- PK
	idEmpresa int references empresa(idEmpresa), -- FG
        idPrestador int references funcionario(idFuncionario), -- FG
        idTrabalho int references trabalho(idTrabalho), -- FG
        horario time,
        dataServico date,
        descricao varchar(200),
        cpfCliente int references cliente(cpf), -- FG
        endereco varchar(200),
        cidade varchar(90),
        estado varchar(90)*/
        
        try{
            var query = "update Servico set "
                    + "idEmpresa = ' " + novo.getIdEmpresa()  + "',"
                    + "idPrestador = ' " + novo.getIdPrestador() + "',"
                    + "idTrabalho = '" + novo.getIdServico() + "',"
                    + "horario = '" + novo.getHorario() + "',"
                    + "dataServico ='" + novo.getData() + "',"
                    + "descricao = '" + novo.getDescricao() + "',"
                    + "cpfCliente = '" + novo.getCpfCliente() + "',"
                    + "endereco = '" + novo.getCidade() + "',"
                    + "estado = '" + novo.getEstado() + "', "
                    + "cidade =  '" + novo.getCidade() + "' "
                    + "where idServico = " + txtBuscaServico.getText() + ";";
            
            this.conectar.updateSQL(query);
            limparCampos();
        }catch(Exception erro){
        
            System.out.println("ERRO AO DAR UPDATE " + erro);}
        
        
    }
    
    private void buscarEmpresas(int valor){
       System.out.println("Executando BuscarEmpresas");
       cbxEmpresa.setModel(new DefaultComboBoxModel());
       id_empresa.clear();
       this.conectar.conectaBanco();
       
       id_empresa.add(novo.getIdEmpresa());
       cbxEmpresa.addItem(novo.getNomeEmpresa());
       
       try{
           var query= "select idEmpresa, nomeEmpresa from Empresa where idEmpresa != " + novo.getIdEmpresa() + ";";
           
           this.conectar.executarSQL(query);
           
           while(this.conectar.getResultSet().next()){
               id_empresa.add(this.conectar.getResultSet().getInt(1));
               cbxEmpresa.addItem(this.conectar.getResultSet().getString(2));
           }
       }catch(Exception erro){
           
       }
    }
    private void buscarPrestador(int valor){
        this.conectar.conectaBanco();
        System.out.println("Executando buscar Prestador");
        cbxPrestador.setModel(new DefaultComboBoxModel());
        id_prestador.clear();
        
        id_prestador.add(novo.getIdPrestador());
        System.out.println("ID do prestador inicial: " + novo.getIdPrestador());
        System.out.println("Procurar funcionarios da empresa ID: " + valor);
        cbxPrestador.addItem(novo.getNomePrestador());
        
        try{
            var query = "Select Funcionario.idFuncionario,Funcionario.nome from Funcionario join empresa on empresa.idEmpresa = Funcionario.idEmpresa where  empresa.idEmpresa ="
                    + valor + " and Funcionario.idFuncionario !=  "  + novo.getIdPrestador() + ";";
            
            this.conectar.executarSQL(query);
            while(this.conectar.getResultSet().next()){
                id_prestador.add(this.conectar.getResultSet().getInt(1));
                cbxPrestador.addItem(this.conectar.getResultSet().getString(2));
            }
        }catch(Exception erro){
            
            System.out.println("ERRO AO BUSCAR FUNCIONARIOS ");
        }
        
    }
    private void buscarTrabalhos(int valorzinho){
        this.conectar.conectaBanco();
        System.out.println("Executando buscarServicos");
        cbxServico.setModel(new DefaultComboBoxModel());
        id_trabalho.clear();
        System.out.println("Empresa buscada: " + valorzinho);
        id_trabalho.add(novo.getIdServico());
        System.out.println("Id do primeiro trabalho: " + id_trabalho.get(0));
        cbxServico.addItem(novo.getTrabalho());
        try{
            var query = "select trabalho.idTrabalho, trabalho.nome from ServicoEmpresa join trabalho on trabalho.idTrabalho = ServicoEmpresa.idtrabalho"
                    + " join empresa on empresa.idEmpresa = ServicoEmpresa.idEmpresa where ServicoEmpresa.idEmpresa = " + valorzinho + " and trabalho.idTrabalho != "
                    + novo.getIdServico() +";";
        
            this.conectar.executarSQL(query);
            
            while(this.conectar.getResultSet().next()){
                id_trabalho.add(this.conectar.getResultSet().getInt(1));
                cbxServico.addItem(this.conectar.getResultSet().getString(2));
            }
        }catch(Exception erro){
    
    }
    }
    private void BuscarServicos(Servico novo){
        this.conectar.conectaBanco();
        System.out.println("EXECUTANDO BUSCAR SERVIÇO ");
        cbxEmpresa.setModel(new DefaultComboBoxModel());
        cbxPrestador.setModel(new DefaultComboBoxModel());
        try{
            var query = "select "
                    + "empresa.nomeEmpresa"
                    + ",Funcionario.nome ,"
                    + "trabalho.nome, "
                    + "horario,"
                    + "dataServico"
                    + ",descricao"
                    + ",cpfCliente"
                    + ",Servico.endereco"
                    + ",Servico.cidade"
                    + ",Servico.estado,"
                    + "Servico.idEmpresa,"
                    + "Servico.idPrestador,"
                    + "Servico.idTrabalho "
                    + "from Servico " +
                    "join empresa on empresa.idEmpresa = Servico.idEmpresa " +
                    "join Funcionario on Funcionario.idFuncionario = Servico.idPrestador " +
                    "join trabalho on trabalho.idTrabalho = Servico.idTrabalho " +
                    "where idServico =  " + txtBuscaServico.getText() + ";";
            
            this.conectar.executarSQL(query);
            
            while(this.conectar.getResultSet().next()){
                novo.setNomeEmpresa(this.conectar.getResultSet().getString(1));
                novo.setNomePrestador(this.conectar.getResultSet().getString(2));
                novo.setTrabalho(this.conectar.getResultSet().getString(3));
                novo.setHorario(this.conectar.getResultSet().getString(4));
                novo.setData(this.conectar.getResultSet().getString(5));
                novo.setDescricao(this.conectar.getResultSet().getString(6));
                novo.setCpfCliente(this.conectar.getResultSet().getInt(7));
                novo.setEndereco(this.conectar.getResultSet().getString(8));
                novo.setCidade(this.conectar.getResultSet().getString(9));
                novo.setEstado(this.conectar.getResultSet().getString(10));
                novo.setIdEmpresa(this.conectar.getResultSet().getInt(11));
                novo.setIdPrestador(this.conectar.getResultSet().getInt(12));
                novo.setIdServico(this.conectar.getResultSet().getInt(13));
            }
            if(novo.getIdServico() == 0 || novo.getIdEmpresa() == 0){
                 JOptionPane.showMessageDialog (null, "Erro ao procurar serviço");
            }else{
                HabilitaCampos(true);
            }
            
        }catch(Exception erro){
                    System.out.println("ERRO AO PROCURAR SERVICO");
        }finally{
            txtBuscarCPF.setText("" + novo.getCpfCliente());
            txtBuscarCidade.setText(novo.getCidade());
            txtBuscarEstado.setText(novo.getEstado());
            txtEndereco.setText(novo.getEndereco());
            txt_data.setText(novo.getData());
            txt_horario.setText(novo.getHorario());
            txtDescricao.setText(novo.getDescricao());
            txtBuscarCidade.setText(novo.getCidade());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarDeletar = new javax.swing.JButton();
        cbxPrestador = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbxServico = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        txt_horario = new javax.swing.JTextField();
        cbxEmpresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscaServico = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        bntBuscarLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarCPF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarCidade = new javax.swing.JTextField();
        txtEstado1 = new javax.swing.JLabel();
        txtBuscarEstado = new javax.swing.JTextField();
        btnBuscarAtualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();

        jLabel11.setText("Empresa ");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscarDeletar.setText("Deletar");
        btnBuscarDeletar.setEnabled(false);
        btnBuscarDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDeletarActionPerformed(evt);
            }
        });

        cbxPrestador.setEnabled(false);
        cbxPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrestadorActionPerformed(evt);
            }
        });

        jLabel13.setText("Tipo de serviço");

        cbxServico.setEnabled(false);
        cbxServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicoActionPerformed(evt);
            }
        });

        jLabel14.setText("Horario");

        jLabel16.setText("Data");

        txt_data.setEnabled(false);

        txt_horario.setEnabled(false);

        cbxEmpresa.setEnabled(false);
        cbxEmpresa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbxEmpresaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpresaActionPerformed(evt);
            }
        });

        jLabel2.setText("Prestador");

        jLabel6.setText("Busca de Empresa");

        jLabel7.setText("Numero do Serviço");

        txtBuscaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaServicoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        bntBuscarLimpar.setText("Limpar");
        bntBuscarLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarLimparActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa");

        jLabel15.setText("Descrição do serviço");

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setEnabled(false);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel8.setText("CPF Cliente");

        txtBuscarCPF.setEnabled(false);
        txtBuscarCPF.setFocusable(false);
        txtBuscarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCPFActionPerformed(evt);
            }
        });

        jLabel9.setText("Endereço");

        txtEndereco.setColumns(20);
        txtEndereco.setLineWrap(true);
        txtEndereco.setRows(5);
        txtEndereco.setEnabled(false);
        jScrollPane1.setViewportView(txtEndereco);

        jLabel10.setText("Cidade");

        txtBuscarCidade.setEnabled(false);
        txtBuscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarCidadeActionPerformed(evt);
            }
        });

        txtEstado1.setText("Estado");

        txtBuscarEstado.setEnabled(false);
        txtBuscarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEstadoActionPerformed(evt);
            }
        });

        btnBuscarAtualizar.setText("Atualizar");
        btnBuscarAtualizar.setEnabled(false);
        btnBuscarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAtualizarActionPerformed(evt);
            }
        });

        jLabel3.setText("00:00:00");

        jLabel4.setText("0000-00-00");

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15)
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(191, 191, 191)
                                    .addComponent(txtEstado1))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBuscarAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(txtBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_data, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_horario, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxServico, javax.swing.GroupLayout.Alignment.LEADING, 0, 210, Short.MAX_VALUE)
                                        .addComponent(cbxPrestador, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxEmpresa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBuscaServico, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnBuscar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bntBuscarLimpar))))
                                .addComponent(txtBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addGap(159, 159, 159))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(bntBuscarLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEstado1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarAtualizar)
                    .addComponent(btnBuscarDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_voltar)
                .addGap(227, 227, 227))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDeletarActionPerformed
         if (JOptionPane.showConfirmDialog(null, "Atualizar registro", "Atualizar o Serviço Numero: " + novo.getIdServico() + " ?" ,
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          DeletarServico();
          limparCampos();
          novo.limpaServico();
          JOptionPane.showMessageDialog (null, "Serviço Apagado");
         }else{
             JOptionPane.showMessageDialog (null, "Algo deu errado ao tentar apagar o serviço ");
         }
        
       
        
        
 

    }//GEN-LAST:event_btnBuscarDeletarActionPerformed

    private void cbxServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxServicoActionPerformed

    private void cbxPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrestadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrestadorActionPerformed

    private void cbxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpresaActionPerformed
        
        
        
        
    }//GEN-LAST:event_cbxEmpresaActionPerformed

    private void btnBuscarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAtualizarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Atualizar registro", "Atualizar o Serviço Numero: " + novo.getIdServico() + " ?" ,
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
             atualizarServico();
             JOptionPane.showMessageDialog (null, "Serviço Atualizado");
        }else{
        }
       

        this.txtBuscarCPF.setText("");
        this.txtBuscaServico.setText("");
        this.txtBuscarCidade.setText("");
        this.txtEndereco.setText("");
        this.txtBuscarCidade.setText("");
        this.txtBuscarEstado.setText("");

    }//GEN-LAST:event_btnBuscarAtualizarActionPerformed

    private void txtBuscarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEstadoActionPerformed

    private void bntBuscarLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarLimparActionPerformed
        HabilitaCampos(false);
        cbxEmpresa.setModel(new DefaultComboBoxModel());
        cbxServico.setModel(new DefaultComboBoxModel());
        cbxPrestador.setModel(new DefaultComboBoxModel());
        this.txtBuscarCPF.setText("");
        this.txtBuscaServico.setText("");
        this.txtBuscarCidade.setText("");
        this.txtEndereco.setText("");
        this.txtBuscarEstado.setText("");
        this.txt_data.setText("");
        this.txt_horario.setText("");
        this.txtEndereco.setText("");
        novo.limpaServico();
    }//GEN-LAST:event_bntBuscarLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        BuscarServicos(novo);
        cbxEmpresa.setModel(new DefaultComboBoxModel());
        buscarEmpresas(novo.getIdEmpresa());
        buscarPrestador(novo.getIdEmpresa());
        buscarTrabalhos(novo.getIdEmpresa());
        
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCidadeActionPerformed

    private void txtBuscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarCPFActionPerformed

    private void txtBuscaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaServicoActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        Menu menuzinho = new Menu();
        menuzinho.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void cbxEmpresaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxEmpresaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpresaPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(BuscarServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarServiço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarServiço().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscarLimpar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarAtualizar;
    private javax.swing.JButton btnBuscarDeletar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JComboBox<String> cbxEmpresa;
    private javax.swing.JComboBox<String> cbxPrestador;
    private javax.swing.JComboBox<String> cbxServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtBuscaServico;
    private javax.swing.JTextField txtBuscarCPF;
    private javax.swing.JTextField txtBuscarCidade;
    private javax.swing.JTextField txtBuscarEstado;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_horario;
    // End of variables declaration//GEN-END:variables


    private void HabilitaCampos(Boolean acao){
        txtBuscarCPF.setEnabled(acao);
        txtEndereco.setEnabled(acao);
        txtBuscarCidade.setEnabled(acao);
        txtBuscarEstado.setEnabled(acao);
        cbxEmpresa.setEnabled(false);
        cbxPrestador.setEnabled(acao);
        cbxServico.setEnabled(acao);
        txt_data.setEnabled(acao);
        txt_horario.setEnabled(acao);
        btnBuscarAtualizar.setEnabled(acao);
        btnBuscarDeletar.setEnabled(acao);
        txtDescricao.setEnabled(acao);
    }
}
