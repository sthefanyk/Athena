package ifpr.proj.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.proj.model.entities.Account;
import ifpr.proj.model.entities.Post;
import ifpr.proj.model.entities.PostAudience;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PostController implements Initializable {
    @FXML
    private ImageView audience;

    @FXML
    private Label caption;

    @FXML
    private Label date;

    @FXML
    private ImageView imgCare;

    @FXML
    private ImageView imgLike;

    @FXML
    private ImageView imgLove;

    @FXML
    private ImageView imgPost;

    @FXML
    private ImageView imgProfile;

    @FXML
    private ImageView imgVerified;

    @FXML
    private HBox likeContainer;

    @FXML
    private Label nbComments;

    @FXML
    private Label nbReactions;

    @FXML
    private Label nbShares;

    @FXML
    private HBox reactionsContainer;

    @FXML
    private Label username;

    public void setData(Post post){

        Image img;
        img = new Image(getClass().getResourceAsStream(post.getAccount().getProfileImg()));

        imgProfile.setImage(img);
        username.setText(post.getAccount().getName());

        
        /*if (post.getAccount().isVerified()) {
            imgVerified.setVisible(true);
        }else
            imgVerified.setVisible(false);
        date.setText(post.getDate());
        if (post.getAudience() == PostAudience.PUBLIC) {
            img = new Image(getClass().getResourceAsStream(PostAudience.PUBLIC.getImgSrc()));
        }else
            img = new Image(getClass().getResourceAsStream(PostAudience.FRIENDS.getImgSrc()));
        audience.setImage(img);
        if (!post.getCaption().isEmpty()) {
            caption.setText(post.getCaption());
        }*/

        if (!post.getImage().isEmpty()) {
            img = new Image(getClass().getResourceAsStream(post.getImage()));
            imgPost.setImage(img);
        }else{
            imgPost.setVisible(false);
        }

        nbReactions.setText(String.valueOf(post.getTotalReactions()));
        nbComments.setText(String.valueOf(post.getNbComments() + " comments"));
        nbShares.setText(String.valueOf(post.getNbShares()) + " shares");

    }

    private Post getPost(){
        Post post = new Post();
        Account account = new Account();
        account.setName("Sthefany");
        account.setProfileImg("../../../img/user.png");
        account.setVerified(true);
        post.setAccount(account);
        post.setDate("Feb 18, 2021 at 12:00 PM");
        post.setAudience(PostAudience.PUBLIC);
        post.setCaption("Hello everybody.");
        post.setImage("../../../img/img2.jpg");
        post.setTotalReactions(10);
        post.setNbComments(2);
        post.setNbShares(3);

        return post;
    }

    // ../../../../../resources/ifpr/proj/img

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        setData(getPost());
    }
}