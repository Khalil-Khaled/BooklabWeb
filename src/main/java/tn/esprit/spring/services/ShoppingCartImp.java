package tn.esprit.spring.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import tn.esprit.spring.DAO.entity.Cart_Action;
import tn.esprit.spring.DAO.entity.Payment_Card;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.DAO.repository.Cart_ActionRepo;
import tn.esprit.spring.DAO.repository.IItemDAO;
import tn.esprit.spring.DAO.repository.ShoppingCartRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartImp implements ShoppingCartInterface<ShoppingCart> {
    @Autowired
    private ShoppingCartRepo scR;

    @Autowired
    private Cart_ActionRepo caR;

    @Autowired
    private IItemDAO irepo;

    @Autowired
    private CouponAdminService scService;
    //checkCouponValidity(String code);
    //getPercentOff(String code);



    @Override
    public ShoppingCart save(ShoppingCart t) {
       return scR.save(t);
    }

    @Override
    public ShoppingCart getLatestSC(int userID) {
        return scR.getLastCart(userID);
    }

    @Override
    public void delete(ShoppingCart sc) {
        scR.delete(sc);
    }

    @Override
    public int pay(Payment_Card card) {
        try{
            Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
            Customer a = Customer.retrieve("sk_test_4eC39HqLyjWDarjtT1zdp7dc");
            Map<String, Object> cardParam = new HashMap<String, Object>();

                cardParam.put("number", card.getCard_number());
                cardParam.put("exp_month", Integer.parseInt(card.getExp_month()));
                cardParam.put("exp_year", Integer.parseInt(card.getExp_year()));
                cardParam.put("cvc", card.getCvc());


            Map <String, Object> tokenParam = new HashMap<String, Object>();
            tokenParam.put("card", cardParam);

            Token token = Token.create(tokenParam);

            Map<String, Object> source = new HashMap<String, Object>();
            source.put("source", token.getId());

            //a.getSources().create(source);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(token));

            Map<String,Object> chargeParam = new HashMap<String, Object>();
            chargeParam.put("amount", card.getAmount());
            chargeParam.put("currency", "usd");
            chargeParam.put("source", token.getId());

            Charge.create(chargeParam);
//            NotificationAPI.notifInfo("Payment", "Your payment was successful!");
//            // Create Order
//            ServicesOrder so = new ServicesOrder();
//
//            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//            Date date = new Date(System.currentTimeMillis());
//            Order O = new Order(SC, true, date);
//            createOrder();
            return Response.SC_OK;

        }catch(StripeException e){
            System.out.println(e.getMessage());
            //NotificationAPI.notif("Payment", "An error has occured with your Payment!");
            return Response.SC_NOT_FOUND;
        }
    }

    @Override
    public double calculateTotal(int cartID){
        ArrayList<Cart_Action> items = caR.getItemsFromCart(cartID);
        double total = 0;
        for(Cart_Action item:items){
            total = item.getAmount() * irepo.getOne(item.getItemID().getItemId()).getPrice();
        }
        //DISCOUNT
        return total;
    }
}
