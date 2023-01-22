import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora {
    private JButton btnCE;
    private JButton btnC;
    private JButton btnBorrar;
    private JButton btn1X;
    private JButton btnporcentaje;
    private JButton btnx2;
    private JButton btna2X;
    private JButton btnDivision;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnMultiplicacion;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnResta;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnSuma;
    private JButton btnsignos;
    private JButton btn0;
    private JButton btnpunto;
    private JButton btnIgual;
    private JPanel panel1;
    private JLabel lbresultado;
    String Dato1, Dato2;
    String signo;
    String resultado;
    Double resultadot=0.0;
    public calculadora() {
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               addNumber("7");
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("9");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("6");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("3");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber("0");            }
        });
        btnpunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena;
                cadena=lbresultado.getText();
                if(cadena.length()<=0)
                {
                    lbresultado.setText("0.");
                }else
                {
                    if(!existepunto(lbresultado.getText()))
                    {
                        lbresultado.setText(lbresultado.getText()+".");
                    }
                }
            }
        });
        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!lbresultado.getText().equals(""))
                {
                    Dato1=lbresultado.getText();
                    signo="/";
                    lbresultado.setText("");
                }
            }
        });
        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=lbresultado.getText();
                signo="*";
                lbresultado.setText("");
            }
        });
        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=lbresultado.getText();
                signo="-";
                lbresultado.setText("");
            }
        });
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=lbresultado.getText();
                signo="+";
                lbresultado.setText("");
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena;
                cadena=lbresultado.getText();
                if(cadena.length()>0)
                {
                    cadena=cadena.substring(0,cadena.length()-1);
                    lbresultado.setText(cadena);
                }
            }
        });
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbresultado.setText("");
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String resultado;
                Dato2=lbresultado.getText();
                if(!Dato2.equals(""))
                {
                    resultado=Calculadora(Dato1,Dato2,signo);
                    lbresultado.setText(resultado);
                }
            }
        });
    }

    private String Calculadora(String dato1, String dato2, String signo) {
        String respuesta;

        if(signo.equals("-"))
        {
            resultadot=Double.parseDouble(dato1)-Double.parseDouble(dato2);
        }
        if(signo.equals("+"))
        {
            resultadot=Double.parseDouble(dato1)+Double.parseDouble(dato2);
        }
        if(signo.equals("/"))
        {
            resultadot=Double.parseDouble(dato1)/Double.parseDouble(dato2);
        }
        if(signo.equals("*"))
        {
            resultadot=Double.parseDouble(dato1)*Double.parseDouble(dato2);
        }
        respuesta=resultadot.toString();
        return respuesta;
    }

    private boolean existepunto(String cadena) {
        boolean resultadob;
        resultadob=false;
        for(int i=0;i<cadena.length();i++)
        {
            if(cadena.substring(i,i+1).equals("."))
            {
                resultadob=true;
                break;
            }
        }

        return resultadob;
    }

    private void addNumber(String digito) {
        lbresultado.setText(lbresultado.getText()+digito);
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Calculadora");

        frame.setContentPane(new calculadora().panel1);
        frame.setSize(250,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}
