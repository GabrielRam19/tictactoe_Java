import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield=new JLabel();
    JButton[] Buttons=new JButton[9];
    boolean player1_turn;

    TicTacToe(){
        //configuraciones del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //configuraciones del campo de texto
        textfield.setForeground(new Color(25,255,0));
        textfield.setBackground(new Color(25,25,25));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        //configuracion del title_panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //Configuracion del tablero
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            Buttons[i]=new JButton();
            button_panel.add(Buttons[i]);
            Buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            Buttons[i].setFocusable(false);
            Buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==Buttons[i]){
                if(player1_turn){
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(255,0,0));
                        Buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("Turno de O");
                        check();
                    }
                }
                else{
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(0,0,255));
                        Buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("Turno de X");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("Turno de X");
        } else{
            player1_turn=false;
            textfield.setText("Turno de O");
        }
    }
    public void check(){
        //revisando si hay ganador de X
        if((Buttons[0].getText()=="X") && (Buttons[1].getText()=="X") && (Buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((Buttons[3].getText()=="X") && (Buttons[4].getText()=="X") && (Buttons[6].getText()=="X")){
            xWins(3,4,5);
        }
        if((Buttons[6].getText()=="X") && (Buttons[7].getText()=="X") && (Buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((Buttons[0].getText()=="X") && (Buttons[3].getText()=="X") && (Buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((Buttons[1].getText()=="X") && (Buttons[4].getText()=="X") && (Buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((Buttons[2].getText()=="X") && (Buttons[5].getText()=="X") && (Buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((Buttons[0].getText()=="X") && (Buttons[4].getText()=="X") && (Buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((Buttons[2].getText()=="X") && (Buttons[4].getText()=="X") && (Buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        //revisando si hay ganador de O
        if((Buttons[0].getText()=="O") && (Buttons[1].getText()=="O") && (Buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((Buttons[3].getText()=="O") && (Buttons[4].getText()=="O") && (Buttons[6].getText()=="O")){
            oWins(3,4,5);
        }
        if((Buttons[6].getText()=="O") && (Buttons[7].getText()=="O") && (Buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((Buttons[0].getText()=="O") && (Buttons[3].getText()=="O") && (Buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((Buttons[1].getText()=="O") && (Buttons[4].getText()=="O") && (Buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((Buttons[2].getText()=="O") && (Buttons[5].getText()=="O") && (Buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((Buttons[0].getText()=="O") && (Buttons[4].getText()=="O") && (Buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((Buttons[2].getText()=="O") && (Buttons[4].getText()=="O") && (Buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b,int c){
        Buttons[a].setBackground(Color.GREEN);
        Buttons[b].setBackground(Color.GREEN);
        Buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            Buttons[i].setEnabled(false);
        }
        textfield.setText("Gana X");
        TicTacToe tictactoe =new TicTacToe();
    }
    public void oWins(int a,int b,int c){
        Buttons[a].setBackground(Color.GREEN);
        Buttons[b].setBackground(Color.GREEN);
        Buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            Buttons[i].setEnabled(false);
        }
        textfield.setText("Gana O");
        TicTacToe tictactoe =new TicTacToe();
    }
}
