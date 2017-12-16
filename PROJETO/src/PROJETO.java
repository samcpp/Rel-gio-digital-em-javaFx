 import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.animation.*;
import javafx.concurrent.Task;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

////////////////////////////////////////////////////////////////////////////////
public class PROJETO extends Application {
     private static Timeline videoTick_1;
     static int a = 0, b = 0, c = 0, d = 0, e = 0,
              f = 0, g = 0, h = 0, k = 0, w = 0;       
     static int hora, min, seg;
     static String str_0 = "";
     static String str_1 = "";
     static String str_2 = "";
     static Canvas canvas = new Canvas ( 490, 310 );
     static GraphicsContext ctx = canvas.getGraphicsContext2D ( );
     static BorderPane borderPane = new BorderPane ( );
     static Text text1 = new Text ( );
     static Button btn_2 = new Button ( "cls" );
     static TextField textField_1 = new TextField ( );
     static HBox hbox_1 = new HBox ( textField_1 );
     static TextField textField_2 = new TextField ( );
     static HBox hbox_2 = new HBox ( textField_2 );
     static TextField textField_3 = new TextField ( );
     static HBox hbox_3 = new HBox ( textField_3 );
     static Pane root = new Pane ( );
     static Scene scene = new Scene ( root, 490, 310, Color.WHITE );
     static MenuBar menuBar = new MenuBar ( );
     // //////////////////////////////////////////////////////////////////////////
     public static int Apaga ( int tam_lin_ini, int tam_lin_fim,
              int tam_ini_col, int tam_fim_col, int cp, int at ) {
         int i, c;
         for ( i = tam_lin_ini; i < tam_lin_fim; i++ ) {
              for ( c = tam_ini_col; c < tam_fim_col; c++ ) {
                   // Coluna, linha, comprimento, altura
                   ctx.clearRect ( c, i, cp, at );
              }
         }
         return 0;
     }
     // //////////////////////////////////////////////////////////////////////////
     // Abaixo a função usada como clock criada por mim
     public static int Sleep_1 ( int x ) {
         ctx.setFont ( Font.font ( "Tahoma", FontWeight.NORMAL, 40 ) );
         Duration duration = Duration.millis ( x );
         do {
              videoTick_1 = new Timeline ( new KeyFrame ( duration,
                        new EventHandler < ActionEvent > ( ) {
                   public void handle ( ActionEvent actionEvent ) {
                        e++;
                        w += str_0.length ( );
                        k = min;
                        str_0 += k;
                        Apaga ( 220, 260, 0, 230 - w, 150, 60 );
                        ctx.setFill ( Color.RED );
                        ctx.fillText ( "0", 218, 250 );
                        if ( k > 9 ) {
                            // Apaga está apagando o "0" acima imprimido
                            // quando o contador chega no 10
                            Apaga ( 220, 260, 190, 300 - w, 150, 60 );
                            a = 25;
                        }
                        if ( k == 60 ) {
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( "00", 218, 250 );
                        }            
                        if ( k <= 59 ) {
                            text1.setStyle ( "-fx-font: normal bold 20px 'serif' " );
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( str_0, 240 - a, 250 );                            
                        }            
                        str_0 = str_0.substring ( 0, w );
                        if ( min == 60 ) {
                            // As variáveis são resetadas para
                            // o retorno do contador
                            min = 0;
                            k = 0;
                            hora++;
                            a = 0;
                        }
                        // //////////////////////////////////////////////////////////
                        f += str_2.length ( );
                        g = hora;
                        str_2 += g;
                        if ( g < 10 ) {
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( "0", 158, 250 );
                        }
                        if ( g > 9 ) {
                            // Apaga está apagando o "0" acima imprimido
                            // quando o contador chega no 10
                            Apaga ( 220, 260, 260, 300 - f, 150, 60 );
                            h = 25;
                        }
                        if ( g == 24 ) {
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( "00", 158, 250 );
                        }
                        ctx.setFill ( Color.RED );
                        ctx.fillText ( ":", 200, 250 );
                        if ( g <= 23 ) {
                            text1.setStyle ( "-fx-font: normal bold 20px 'serif' " );
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( str_2, 180 - h, 250 );
                        }
                        str_2 = str_2.substring ( 0, f );
                        if ( hora == 24 ) {
                            // As variáveis são resetadas para
                            // o retorno do contador
                            hora = 0;
                            g = 0;
                            h = 0;
                        }
                        // //////////////////////////////////////////////////////////
                        b += str_1.length ( );
                        c = seg;
                        str_1 += c;
                        ctx.setFill ( Color.RED );
                        ctx.fillText ( "0", 278, 250 );
                        if ( c > 9 ) {
                            // Apaga está apagando o "0" acima imprimido
                            // quando o contador chega no 10
                            Apaga ( 220, 260, 270, 300 - b, 150, 60 );
                            d = 25;
                        }
                        if ( c <= 59 ) {
                            text1.setStyle ( "-fx-font: normal bold 20px 'serif' " );
                            ctx.setFill ( Color.RED );
                            ctx.fillText ( str_1, 300 - d, 250 );
                        }
                        ctx.setFill ( Color.RED );
                        ctx.fillText ( ":", 260, 250 );
                        str_1 = str_1.substring ( 0, b );
                        seg++;
                        if ( seg == 60 ) {
                            // As variáveis são resetadas para
                            // o retorno do contador
                            seg = 0;
                            c = 0;
                            d = 0;
                            min++;
                        }
                   }
              } ) );
              videoTick_1.setCycleCount ( Animation.INDEFINITE );
              videoTick_1.playFromStart ( );
              return k;
         } while ( true );
     }
     // /////////////////////////////////////////////////////////////////////////
     // Chamando uma função depois de um certo tempo
     public static void Tempo_3 ( ) {
         ctx.setFill ( Color.RED );
         ctx.fillText ( "Criado por: ", 280, 230 );
     }
     public static void Tempo_2 ( ) {
         ctx.setFill ( Color.BLUE );
          ctx.fillText ( "Samuel Lima", 280, 260 );
     }
     public static void Tempo_1 ( ) {
         // Coluna, linha, comprimento, altura
         // Apagando uma linha ou partes
         ctx.clearRect ( 150, 210, 280, 60 );
     }
     // /////////////////////////////////////////////////////////////////////////
     public static int Sleep ( int x, int k ) {
         Task < Integer > close = new Task < Integer > ( ) {
              @Override
              protected Integer call ( ) throws Exception {
                   Thread.sleep ( x );
                   return null;
              }
         };
         close.setOnSucceeded ( c -> {
              if ( k == 1 )
                   Tempo_1 ( );
              if ( k == 2 )
                   Tempo_2 ( );
              if ( k == 3 )
                   Tempo_3 ( );
         } );
         new Thread ( close ).start ( );
         return 0;
     }
     // /////////////////////////////////////////////////////////////////////////
     public static Node But_ton_1 ( ) {
         Button btn_1 = new Button ( "cls" );
         btn_1.setPrefWidth ( 50 );// Largura do botão
         btn_1.setLayoutX ( 22 );// Posição do botão
         btn_1.setPrefHeight ( 20 );// altura do botão
         btn_1.setLayoutY ( 272 );// //Posição do botão
         btn_1.setOnAction ( new EventHandler < ActionEvent > ( ) {
              @Override
              public void handle ( ActionEvent event ) {
                   // Coluna, linha, comprimento, altura
                   // Apagando uma linha ou partes
                   //ctx.clearRect ( 150, 210, 280, 60 );
                   ctx.clearRect ( 50, 60, 380, 260 );
                   //Esconde o textfield
                   textField_1 .setVisible ( false );
              }
         } );
         root.getChildren ( ).add ( btn_1 );
         return btn_1;
     }
     // /////////////////////////////////////////////////////////////////////////
     public static int Menu_Bar ( ) {
         EventHandler < ActionEvent > action = changeTabPlacement ( );
         Menu menu = new Menu ( "Arq" );
         MenuItem top = new MenuItem ( "Exit" );
         top.setOnAction ( action );
         menu.getItems ( ).add ( top );
         MenuItem bottom = new MenuItem ( "Inf" );
         bottom.setOnAction ( action );
         menu.getItems ( ).add ( bottom );
         menuBar.getMenus ( ).add ( menu );
         root.prefHeightProperty ( ).bind ( scene.heightProperty ( ) );
         root.prefWidthProperty ( ).bind ( scene.widthProperty ( ) );
         borderPane.setTop ( menuBar );
         return 0;
     }
     // /////////////////////////////////////////////////////////////////////////
     private static EventHandler < ActionEvent > changeTabPlacement ( ) {
         return new EventHandler < ActionEvent > ( ) {
              public void handle ( ActionEvent event ) {
                   MenuItem mItem = ( MenuItem ) event.getSource ( );
                   String side = mItem.getText ( );
                   int b = 0;
                   if ( "Exit".equalsIgnoreCase ( side ) ) {
                        System.exit ( 0 );
                   } else if ( "Inf".equalsIgnoreCase ( side ) ) {
                        textField_1 .setVisible ( false );
                        textField_2 .setVisible ( false );
                        textField_3 .setVisible ( false );
                        ctx.clearRect ( 50, 60, 380, 260 );
                        But_ton_1 ( );
                        b = 2;
                        Sleep ( 2800, 2 );
                        b = 3;
                        Sleep ( 1800, 3 );
                        b = 4;
                        Sleep ( 1800, b );
                   }
              }
         };
     }
    // ////////////////////////////////////////////////////////////////////////
   public static void limitTextField ( TextField textField, int limit ) {
       UnaryOperator < Change > textLimitFilter = change -> {
            if ( change.isContentChange ( ) ) {
                 int newLength = change.getControlNewText ( ).length ( );
                 if ( newLength > limit ) {
                      String trimmedText = change.getControlNewText ( )
                               .substring ( 0, limit );
                      change.setText ( trimmedText );
                      int oldLength = change.getControlText ( ).length ( );
                      change.setRange ( 0, oldLength );
                 }
            }
            return change;
       };
       textField.setTextFormatter ( new TextFormatter < Object > (
                 textLimitFilter ) );
   }
     // /////////////////////////////////////////////////////////////////////////
     public static int horas ( ) {
         // Textfield      
         hbox_1.setPadding ( new Insets ( 130, 0, 10, 100 ) );
         // Abaixo ajustamos o total de colunas do TextField
         textField_1.setPrefColumnCount ( 2 );
         textField_1.setPromptText("hrs");
         ctx.setFont ( Font.font ( "Tahoma", FontWeight.NORMAL, 12 ) );
         ctx.setFill ( Color.RED );
         ctx.fillText ( "Horas", 100, 120 );
         textField_1.setOnKeyPressed ( new EventHandler < KeyEvent > ( ) {
              @Override         
              public void handle ( KeyEvent event ) {
                   limitTextField ( textField_1, 2 );
                   if ( event.getCode ( ) == KeyCode.ENTER ) {            
                        ctx.setFont ( Font.font ( "Arial", FontWeight.NORMAL, 13 ) );
                        ctx.setFill ( Color.BLUE );
                        // convertendo string para inteiro
                        hora = Integer.parseInt ( textField_1.getText ( ) );
                        if ( Integer.parseInt ( textField_1.getText ( ) ) > -1
                                 && Integer.parseInt ( textField_1.getText ( ) ) < 24 ) {
                            System.out.println ( hora );
                            minutos ( );
                        }
                   }
              }
         } );
         root.getChildren ( ).addAll ( hbox_1 );
         return 0;
     }
     // //////////////////////////////////////////////////////////////////////////
     public static int minutos ( ) {
         // Textfield
         hbox_2.setPadding ( new Insets ( 130, 0, 10, 180 ) );
         // Abaixo ajustamos o total de colunas do TextField
         textField_2.setPrefColumnCount ( 2 );
         textField_2.setPromptText("mts");
         ctx.setFont ( Font.font ( "Tahoma", FontWeight.NORMAL, 12 ) );
         ctx.setFill ( Color.RED );
         ctx.fillText ( "Minutos", 180, 120 );
         textField_2.setOnKeyPressed ( new EventHandler < KeyEvent > ( ) {
              @Override
              public void handle ( KeyEvent event ) {
                   limitTextField ( textField_2, 2 );
                   if ( event.getCode ( ) == KeyCode.ENTER ) {
                        ctx.setFont ( Font.font ( "Arial", FontWeight.NORMAL, 13 ) );
                        ctx.setFill ( Color.BLUE );
                        // convertendo string para inteiro
                        min = Integer.parseInt ( textField_2.getText ( ) );
                        if ( Integer.parseInt ( textField_2.getText ( ) ) > 0
                                 && Integer.parseInt ( textField_2.getText ( ) ) < 60 ) {
                            System.out.println ( min );
                            segundos ( );
                        }
                   }
              }
         } );
         root.getChildren ( ).add ( hbox_2 );
         return 0;
     }
     // //////////////////////////////////////////////////////////////////////////
     public static int segundos ( ) {
         // Textfield
         hbox_3.setPadding ( new Insets ( 130, 0, 10, 260 ) );
         // Abaixo ajustamos o total de colunas do TextField
         textField_3.setPrefColumnCount ( 2 );
         textField_3.setPromptText("sgs");
         ctx.setFont ( Font.font ( "Tahoma", FontWeight.NORMAL, 12 ) );
         ctx.setFill ( Color.RED );
         ctx.fillText ( "Segundos", 260, 120 );
         textField_3.setOnKeyPressed ( new EventHandler < KeyEvent > ( ) {
              @Override
              public void handle ( KeyEvent event ) {
                   limitTextField ( textField_3, 2 );
                   if ( event.getCode ( ) == KeyCode.ENTER ) {
                        ctx.setFont ( Font.font ( "Arial", FontWeight.NORMAL, 13 ) );
                        ctx.setFill ( Color.BLUE );
                        // convertendo string para inteiro
                        seg = Integer.parseInt ( textField_3.getText ( ) );
                        if ( Integer.parseInt ( textField_3.getText ( ) ) > 0
                                 && Integer.parseInt ( textField_3.getText ( ) ) < 60 ) {
                            System.out.println ( seg );
                            System.out.println ( "RELÓGIO DIGITAL EM JAVA" );
                            Sleep_1 ( 1000 );
                            textField_1 .setVisible ( false );
                            textField_2 .setVisible ( false );
                            textField_3 .setVisible ( false );
                            ctx.clearRect ( 50, 60, 380, 260 );
                        }
                   }
              }
         } );
         root.getChildren ( ).add ( hbox_3 );
         return 0;
     }
     // /////////////////////////////////////////////////////////////////////////
     public void start ( Stage stage ) {
         stage.setTitle ( "RELÓGIO DIGITAL EM JAVAFX" );   
         // Dando uns efeitos na moldura
         root.setStyle ( "-fx-padding: 5;" + "-fx-border-style: solid inside;"
                   + "-fx-border-width: 18;" + "-fx-border-insets: 5;"
                   + "-fx-border-radius: 5;" + "-fx-border-color: blue;" );
         //Com este comando a tela não se espande
         stage.setResizable ( false );
         Menu_Bar ( );
         ctx.setFill ( Color.RED );
         ctx.setFont ( Font.font ( "Serif", FontWeight.BOLD, 20 ) );
         ctx.fillText ( "RELÓGIO DIGITAL EM JAVAFX", 100, 50 );
         ctx.setFont ( Font.font ( "Arial", FontWeight.NORMAL, 15 ) );
         ctx.setFill ( Color.BLACK );
         ctx.fillText ( "Vamos acertar nosso relógio", 120, 100 );
         root.getChildren ( ).add ( canvas );
         horas ( );
         // Configurando o local exato do menu
         borderPane.setPadding ( new Insets ( 23, 0, 5, 23 ) );
         root.getChildren ( ).addAll ( borderPane );
         stage.setScene ( scene );
         stage.show ( );
     }
     // /////////////////////////////////////////////////////////////////////////
     public static void main ( String [ ] args ) {
         Application.launch ( args );
     }
}
