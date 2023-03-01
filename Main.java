import javax.swing.*;


// the main class to execute the code
public class Main {

    public static void main(String[] args)
    {

        String outputResult = "";
        boolean displayGui = true;

        for(String word: args){
            // System.out.println(word);

            if (word.equals("Gui") ) {
                displayGui = true;
                break;
            }

            outputResult += word; 
            outputResult += " ";
        }

        String message = outputResult.length() > 0 ? outputResult : "Hello World";
        
        HelloWorld helloWorldObj = new HelloWorld(message);

        if(displayGui == true) {
            Gui guiDisplay = new Gui(helloWorldObj);
            
            guiDisplay.displayGui();
        
        } else {
            helloWorldObj.print();
        }

    }
}

// the class that prints Hello world
class HelloWorld
{
    private String message;

    // default constructor that initialize the message if no inputs are given
    HelloWorld()
    {
        message = "Hello world";
    }

    HelloWorld(String message)
    {
        this.message = message;
    }

    // method that prints the message
    public void print()
    {
        System.out.println(message);
    }

    public String getMessage(){
        return message;
    } 
}

class Gui{
    private String messageToDisplay;

    public Gui(HelloWorld helloWorldObj){
        messageToDisplay = helloWorldObj.getMessage();
    } 

    public void displayGui(){

       JFrame frame = new JFrame(messageToDisplay + " GUI ");
       JLabel text = new JLabel(messageToDisplay);
       JPanel panel = new JPanel();

       panel.add(text);
       frame.getContentPane().add(panel); // Adds Button to content pane of frame

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       frame.setVisible(true);
    }
}
