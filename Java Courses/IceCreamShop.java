/**
 * Jonathan Vera
 * COP3337 Section U02
 * Assignment 3
 * Another Decorator Example but with GUI
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class IceCreamShop {

    Item icItem;
    JButton dishButton = new JButton("Dish");
    JButton coneButton = new JButton("Cone");
    JButton finishButton = new JButton("Finish");
    JButton closeButton = new JButton("Close");
    int scoops = 0;
    boolean dish;
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<ItemButton> flavors = new ArrayList<ItemButton>();
    ArrayList<ItemButton> toppings = new ArrayList<ItemButton>();
    JFrame window;

    public IceCreamShop() throws IOException {

        window = new JFrame("Plain Ice Cream Shop");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int width = (int) (toolkit.getScreenSize().getWidth()) / 2;
        int height = (int) (toolkit.getScreenSize().getHeight()) / 2;
        window.setSize(width, height);
        window.setLocation(width / 2, height / 2);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout(FlowLayout.CENTER, width, 30));
        JLabel containerLable = new JLabel("Dish or Cone");
        window.add(containerLable);
        dishButton.addActionListener(new ContainerAction());
        coneButton.addActionListener(new ContainerAction());
        JPanel containerPanel = new JPanel();
        containerPanel.add(dishButton);
        containerPanel.add(coneButton);
        window.add(containerPanel);
        JLabel flavorLable = new JLabel("Please choose a flavor. No more than three scoops, however.");
        window.add(flavorLable);
        //get flavors
        Scanner flavorScan = new Scanner(new File("src/flavors.data"));
        flavorScan.useDelimiter("[:\n\r]+");
        while (flavorScan.hasNext()) {
            ItemButton current = new ItemButton(flavorScan.next(), flavorScan.nextDouble());
            current.setText(current.getDescription());
            flavors.add(current);
        }
        flavorScan.close();
        JPanel flavorPanel = new JPanel();
        for (int i = 0; i < flavors.size(); i++) {
            flavors.get(i).addActionListener(new FlavorAction());
            flavors.get(i).setEnabled(false);
            flavorPanel.add(flavors.get(i));
        }
        window.add(flavorPanel);
        //get toppings
        Scanner toppingsScan = new Scanner(new File("src/toppings.data"));
        toppingsScan.useDelimiter("[:\n\r]+");
        while (toppingsScan.hasNext()) {
            ItemButton current = new ItemButton(toppingsScan.next(), toppingsScan.nextDouble());
            current.setText(current.getDescription());
            toppings.add(current);
        }
        toppingsScan.close();

        JLabel toppingLable = new JLabel("Choose topping(s) (for dish of ice cream only).");
        window.add(toppingLable);
        JPanel toppingPanel = new JPanel();
        for (int i = 0; i < toppings.size(); i++) {
            toppings.get(i).addActionListener(new ToppingAction());
            toppings.get(i).setEnabled(false);
            toppingPanel.add(toppings.get(i));
        }
        window.add(toppingPanel);
        window.add(finishButton);
        finishButton.addActionListener(new FinishAction());
        window.add(closeButton);
        closeButton.addActionListener(new CloseAction());
        dish = false;
        window.setVisible(true);
    }

    String fixFlavors(String flavor, String s) {
        String match = ":" + flavor + ":";
        int first = s.indexOf(match);
        if (first == -1) {
            return s;
        }
        int next = s.indexOf(match, first + match.length());
        if (next == -1) {
            s = s.substring(0, first - 1) + " a scoop of "
                    + flavor + s.substring(first + match.length());
            return s;
        } // end if
        s = s.substring(0, next) + s.substring(next + match.length());
        next = s.indexOf(match, first + match.length());
        if (next == -1) {
            s = s.substring(0, first - 1) + " a double scoop of "
                    + flavor + s.substring(first + match.length());
            return s;
        } // end if
        s = s.substring(0, next) + s.substring(next + match.length());
        s = s.substring(0, first - 1) + " a triple scoop of " + flavor
                + s.substring(first + match.length());
        return s;
    }

    interface Item {

        public String getDescription();

        public double getCost();
    }

    class ItemButton extends JButton {

        String item;
        double cost;

        public ItemButton(String item, double cost) {
            super(item);
            this.item = item;
            this.cost = cost;
        }

        public String getDescription() {
            return this.item;
        }

        public double getCost(){
            return this.cost;
        }
    }

    class Cone implements Item {

        public String getDescription() {
            return "Cone with";
        }

        public double getCost() {
            return 1.00;
        }
    }

    class Dish implements Item {

        public String getDescription() {
            return "Dish with";
        }

        public double getCost() {
            return 0.10;
        }
    }

    class ItemWrapper implements Item {

        Item item;

        public ItemWrapper(Item item) {
            this.item = item;
        }

        public String getDescription() {
            return item.getDescription();
        }

        public double getCost() {
            return item.getCost();
        }
    }

    class Flavor extends ItemWrapper {

        String flavor;
        double cost;

        public Flavor(Item item, String flavor, double cost) {
            super(item);
            this.flavor = flavor;
            this.cost = cost;
        }

        public String getDescription() {
            return item.getDescription() + " :" + flavor + ":";
        }

        public double getCost() {
            return item.getCost() + cost;
        }
    }

    class Topping extends ItemWrapper {

        String topping;
        double cost;

        public Topping(Item item, String topping, double cost) {
            super(item);
            this.topping = topping;
            this.cost = cost;
        }

        public String getDescription() {
            return item.getDescription() + " with " + topping;
        }

        public double getCost() {
            return item.getCost() + cost;
        }
    }
    
    class ContainerAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String item = event.getActionCommand();
            if (item.equals("Dish")) {
                icItem = new Dish();
                dish = true;
            }
            if (item.equals("Cone")) {
                icItem = new Cone();
            }
            dishButton.setEnabled(false);
            coneButton.setEnabled(false);
            for (int i = 0; i < flavors.size(); i++) {
                flavors.get(i).setEnabled(true);
            }
        }
    }

    class FlavorAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            scoops++;
            String flavor = event.getActionCommand();
            double cost = 0;
            for(int i = 0; i <flavors.size(); i++){
                if(flavor.equals(flavors.get(i).getDescription())){
                    cost = flavors.get(i).getCost();
                }
            }
            icItem = new Flavor(icItem, flavor, cost);
            if (dish) {
                for (int i = 0; i < toppings.size(); i++) {
                    toppings.get(i).setEnabled(true);
                }
            }
            if (scoops == 3) {
                for (int i = 0; i < flavors.size(); i++) {
                    flavors.get(i).setEnabled(false);
                }
            }
        }
    }

    class ToppingAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String topping = event.getActionCommand();
            dish = false;
            double cost = 0;
            for(int i = 0; i <flavors.size(); i++){
                if(topping.equals(toppings.get(i).getDescription())){
                    cost = toppings.get(i).getCost();
                }
            }
            icItem = new Topping(icItem, topping, cost);
            for (int i = 0; i < toppings.size(); i++) {
                if (topping.equals(toppings.get(i).getDescription())) {
                    toppings.get(i).setEnabled(false);
                }
            }
        }
    }

    class FinishAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (icItem == null) {
                return;
            }

            String type = icItem.getClass().toString();
            if (type.contains("Cone") || type.contains("Dish")) {
                JOptionPane.showMessageDialog(null, "You must choose an ice cream!");
                return;
            }
            items.add(icItem);
            NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
            String out = "Your Order is: \n";
            String description = icItem.getDescription();
            for (int i = 0; i < flavors.size(); i++) {
                description = fixFlavors(flavors.get(i).getDescription(), description);
            }
            out += description + "\n";
            out += money.format(icItem.getCost());
            JOptionPane.showMessageDialog(null, out + "\nEnjoy!");
            dishButton.setEnabled(true);
            coneButton.setEnabled(true);
            for (int i = 0; i < flavors.size(); i++) {
                flavors.get(i).setEnabled(false);
            }
            for (int i = 0; i < toppings.size(); i++) {
                toppings.get(i).setEnabled(false);
            }
            icItem = null;
            scoops = 0;
            dish = false;
        }
    }

    class CloseAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String out = "";
            for (int i = 0; i < items.size(); i++) {
                out += items.get(i).getDescription() + " " + items.get(i).getCost() + "\n";
            }
            JOptionPane.showMessageDialog(null, out);
            window.dispose();
        }
    }

    public static void main(String[] args) throws IOException {
        IceCreamShop plain = new IceCreamShop();
    }
}