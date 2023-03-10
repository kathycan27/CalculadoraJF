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
    private JTextField txtresultado;
    String Dato1, Dato2;
    String signo;
    String resultado;
    Double resultadot=0.0;
    public calculadora() {
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //lbresultado.setText("");
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
                cadena=txtresultado.getText();
                if(cadena.length()<=0)
                {
                    txtresultado.setText("0.");
                }else
                {
                    if(!existepunto(txtresultado.getText()))
                    {
                        txtresultado.setText(txtresultado.getText()+".");
                    }
                }
            }
        });
        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtresultado.getText().equals(""))
                {
                    Dato1=txtresultado.getText();
                    signo="/";
                    txtresultado.setText("");
                }
            }
        });
        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=txtresultado.getText();
                signo="*";
                txtresultado.setText("");
            }
        });
        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=txtresultado.getText();
                signo="-";
                txtresultado.setText("");
            }
        });
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato1=txtresultado.getText();
                signo="^";
                txtresultado.setText("");
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena;
                cadena=txtresultado.getText();
                if(cadena.length()>0)
                {
                    cadena=cadena.substring(0,cadena.length()-1);
                    txtresultado.setText(cadena);
                }
            }
        });
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtresultado.setText("");
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String resultado;
                Dato2=txtresultado.getText();
                if(!Dato2.equals(""))
                {
                    resultado=Calculadora(Dato1,Dato2,signo);
                    txtresultado.setText(resultado);
                }
            }
        });
        btnx2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double potencia=Double.parseDouble(txtresultado.getText());
                txtresultado.setText(String.valueOf(Math.pow(potencia,2)));

            }
        });
        btna2X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double raiz=Double.parseDouble(txtresultado.getText());
                txtresultado.setText(String.valueOf(Math.sqrt(raiz)));
            }
        });
        btnporcentaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double porcentaje=Double.parseDouble(txtresultado.getText());
                txtresultado.setText(String.valueOf(porcentaje/100));
            }
        });
        btn1X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double invertir=Double.parseDouble(txtresultado.getText());
                txtresultado.setText(String.valueOf(1/invertir));
            }
        });
        btnsignos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cambio=Double.parseDouble(txtresultado.getText());
                txtresultado.setText(String.valueOf(-cambio));
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
        txtresultado.setText(txtresultado.getText()+digito);
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Calculadora");

        frame.setContentPane(new calculadora().panel1);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }


}
