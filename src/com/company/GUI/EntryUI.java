package com.company.GUI;

import com.company.ServerProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * EntryUI Class is used to start server + Clients, wont allow more than 2 Clients at once
 */
public class EntryUI {
    /**
     * Getter+Setter for int clientNum
     * @return
     */
    public int getClientNum() {
        return clientNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    private int clientNum = 0;


    public JLabel enterName = new JLabel("Enter Name: ");

    public JLabel chooseName = new JLabel("Choose Name: ");

    ArrayList<String> playerNames = new ArrayList<>();

    public EntryUI() {

    }

    JFrame options = new JFrame();
    JPanel panel = new JPanel();
    JButton addClient = new JButton("Start Client");
    JButton startServer = new JButton("Start Server");


    /**
     * converts the arraylist playerNames to a string array which can then be used by the JComboBox in the Name UI
     * @return the useable String[]
     */
    public String[] playerNamesToString(){
        playerNames.add("Lasse");
        playerNames.add("Sven");
        //playerNames.add("Fabian");
        int l=playerNames.size();
        String[] arrayNames= playerNames.toArray(new String[playerNames.size()]);

        return arrayNames;
    }


    /**
     * Füllt das Optionen UI mit den entsprechenden Komponenten + stellt die zugehörigen Actionlistener zur Verfügung
     */
    public void initOptionsUI() {

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridBagLayout());
        panel.add(startServer);
        startServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchServer();
            }
        });
        panel.add(addClient);
        addClient.addActionListener((new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inputName();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }));
        options.add(panel, BorderLayout.CENTER);
        options.setTitle("Optionen");
        options.setSize(640, 640);
        options.setResizable(true);
        options.setLocationRelativeTo(null);
        options.setVisible(true);

    }

    /**
     * startet den server per mainCaller() methode der Klasse ServerProgramm
     */
    public void launchServer() {
        try {
            ServerProgram.mainCaller();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * im terribly sorry for this monstrosity. i swear.
     * basically this method handles all kinds of input related to the username.
     * it either accepts a new one and adds it to the list + serializes it or allows to choose one of the usernames of the deserialized String[] playerNames
     * also handles the entire UI which pops up. yeah. this is bad.
     * @throws IOException
     */
    public void inputName() throws IOException {
        deserializeArrayList();
        JFrame input = new JFrame();
        input.setTitle("Choose your name/Enter your name");
        input.setLayout(new GridBagLayout());
        JButton start = new JButton("Start");
        JButton startWithName = new JButton("Start with name");
        JComboBox jcb = new JComboBox(playerNamesToString());
        GridBagConstraints c = new GridBagConstraints();
        JTextField name = new JTextField();
        input.setSize(400,400);
        input.setLocationRelativeTo(null);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        input.add(enterName,c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        input.add(name,c);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String playername = name.getText();
                    playerNames.add(playername);
                    launchClient();
                    System.out.println("Connected as: " + playername);
                    serializeArrayList(playerNames);
                    input.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        c.gridx=2;
        input.add(start,c);
        c.gridx=0;
        c.gridy=1;
        c.weightx=1;
        input.add(chooseName,c);
        c.gridx=1;
        input.add(jcb,c);
        startWithName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playername = Objects.requireNonNull(jcb.getSelectedItem()).toString();
                System.out.println("Connected as: " + playername);
                try {
                    launchClient();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                input.dispose();
            }
        });
        c.gridx=2;
        input.add(startWithName,c);


        input.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        input.setVisible(true);


    }


    /**
     * startet neuen Clienten + trackt die Anzahl der Clienten
     * Sollte zur Laufzeit ein Client geschlossen werden muss das Programm neu gestartet werden
     *
     * @throws IOException
     * @param
     */
    public void launchClient() throws IOException {
        if (clientNum < 2) {
            UI board = new UI();
            board.initGameboard();
            board.addAllPieces();
            clientNum++;
        }
        else{
            System.out.println("Max number of clients reached.");
        }
    }
    public void serializeArrayList(ArrayList<String> arraylist){
        try{
            FileOutputStream fos = new FileOutputStream("playerNames");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arraylist);
            oos.close();
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deserializeArrayList(){
        try
        {
            FileInputStream fis = new FileInputStream("playerNames");
            ObjectInputStream ois = new ObjectInputStream(fis);

            playerNames = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();

        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();

        }
    }
}