import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    private JTextField ID;
    private JLabel Country;
    private JComboBox comboBox_countries;
    private JRadioButton Button1pri;
    private JRadioButton Button2pri;
    private JRadioButton Button3pri;
    private JPanel mainPanel;
    private JTextArea TextDesc;
    private JTextArea textArea1;
    private JTextField textWeight;
    private JTextField textRemitent;
    private JCheckBox checkBox1;
    private JTextField textReceiver;
    private JButton pileButton;
    private JButton unpileButton;
    private JTextField textColumnNumber;
    private JButton showContainerDescriptionButton;
    private JTextArea ContainerDescription;
    private JButton numberOfContainersButton;
    private JComboBox comboBox2;
    private JTextField putNumberHereTextField;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JLabel logo;
    private JButton checkButton;


    public MainFrame(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setSize(1280,720);
        setSize(1920,1080);
        ImageIcon icono = new ImageIcon("logo.png");

        this.setTitle("Hub");
//        setSize(1920,1200);
        setVisible(true);
        //textArea1.setLineWrap(true);
        //textArea1.setWrapStyleWord(true);
        TextDesc.setLineWrap(true);
        TextDesc.setWrapStyleWord(true);
        ContainerDescription.setLineWrap(true);
        ContainerDescription.setWrapStyleWord(true);
//        String remi = textRemitent.getText();
//
//        textArea1.setText(remi);
        Hub hub = new Hub();
        Hub hub2 = new Hub();
        Hub hub3 = new Hub();

        pileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==pileButton){
                    Integer aid = 0;
                    Integer aweigth = 0;
                    try{
                         aid = (Integer.parseInt(ID.getText()));
                        aweigth=(Integer.parseInt(textWeight.getText()));
                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Introduce ID and weigth properly.", "Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
//                    int aid = (Integer.parseInt(ID.getText()));
//                    int aweigth=(Integer.parseInt(textWeight.getText()));
                    String adescrip=(TextDesc.getText());
                    int apri;
                    if (Button1pri.isSelected()){
                        apri=(1);
                    }
                    else if(Button2pri.isSelected()){
                        apri=(2);
                    }
                    else{
                        apri=(3);
                    }
                    String areceiver = (textReceiver.getText());
                    String asender = (textRemitent.getText());
                    boolean inspect = checkBox1.isSelected();
//                    System.out.println( inspect);
                    String content = TextDesc.getText();
                    String country = (String)comboBox_countries.getSelectedItem();
//                    System.out.println(country);

                    Container a = new Container(aid, aweigth, country, inspect, apri, content, asender, areceiver);
                    if( hub.stack(a))
                        System.out.println("stack successfully");
                    else{
                        if (hub2.stack(a)){
                            System.out.println("stack successfully");
                        }
                        else{
                            if(hub3.stack(a)){
                                System.out.println("stack successfully");
                            }
                            else{
                                System.out.println("error stacking");
                                JOptionPane.showMessageDialog(null, "There is no free space to stack", "Error", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }


                    }


                    textArea1.setText(hub.toString());
                    textArea2.setText(hub2.toString());
                    textArea3.setText(hub3.toString());
                }
            }
        });
        numberOfContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == numberOfContainersButton){
                    int num = (int)hub.count((String) comboBox2.getSelectedItem());
                    int num2 = (int)hub2.count((String) comboBox2.getSelectedItem());
                    int num3 = (int)hub3.count((String) comboBox2.getSelectedItem());
                    int suma = num + num2 + num3;
                    putNumberHereTextField.setText("" + suma);

                    Container[][] c = hub.getContainers();
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j<12; j++){
                            if(c[i][j] == null ){
                                System.out.print("\u001B[32mE ");
                            }
                            if(c[i][j] != null)
                                System.out.print("\u001B[31mF ");

                        }
                        System.out.println();

                    }
                    System.out.println();
                }

            }
        });
        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column =  Integer.parseInt(textColumnNumber.getText()) - 1;
                int apri;
                if (Button1pri.isSelected()){
                    apri=(1);
                }
                else if(Button2pri.isSelected()){
                    apri=(2);
                }
                else{
                    apri=(3);
                }
                switch (apri){
                    case 1:
                        if (hub.unstack(column))
                            System.out.println("unstack successfully");
                        else
                            System.out.println( "error unstacking");
                        textArea1.setText(hub.toString());
                        textArea2.setText(hub2.toString());
                        textArea3.setText(hub3.toString());
                        break;
                    case 2:
                        if (hub2.unstack(column))
                            System.out.println("unstack successfully");
                        else
                            System.out.println( "error unstacking");
                        textArea1.setText(hub.toString());
                        textArea2.setText(hub2.toString());
                        textArea3.setText(hub3.toString());
                        break;
                    case 3:
                        if (hub3.unstack(column))
                            System.out.println("unstack successfully");
                        else
                            System.out.println( "error unstacking");
                        textArea1.setText(hub.toString());
                        textArea2.setText(hub2.toString());
                        textArea3.setText(hub3.toString());
                        break;
                }


            }
        });
        showContainerDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id =  (Integer.parseInt(ID.getText()));
                ContainerDescription.setText(hub.searchid(id));
                //JOptionPane.showMessageDialog(null, "Este es un mensaje de información", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int apri;
                if (Button1pri.isSelected()){
                    apri=(1);
                }
                else if(Button2pri.isSelected()){
                    apri=(2);
                }
                else{
                    apri=(3);
                }
                Integer aweigth = 0;
                aweigth=(Integer.parseInt(textWeight.getText()));
                switch (apri){
                    case 1:
                        JOptionPane.showMessageDialog(null, hub.methodex(aweigth,1), "Check", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:

                        JOptionPane.showMessageDialog(null, hub2.methodex(aweigth,2), "Check", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, hub3.methodex(aweigth,3), "Check", JOptionPane.INFORMATION_MESSAGE);

                        break;
                }

            }
        });
    }


    public static void main(String[] args) {


        MainFrame myframe = new MainFrame();


    }


}
