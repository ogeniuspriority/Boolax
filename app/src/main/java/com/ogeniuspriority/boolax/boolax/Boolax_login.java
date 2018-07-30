package com.ogeniuspriority.boolax.boolax;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import es.dmoral.toasty.Toasty;
import mehdi.sakout.fancybuttons.FancyButton;

public class Boolax_login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {
    FancyButton Boolax_login;
    LoginButton Boolax_facebook;
    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    private String fbAccessToken;
    SignInButton Boolax_google;
    //------------For google sigin in--
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
    private static final String TAG = "SignInTestActivity";
    // A magic number we will use to know that our sign-in error
    // resolution activity has completed.
    private static final int OUR_REQUEST_CODE = 49404;
    // The core Google Play Services client.
    private GoogleApiClient mGoogleApiClient;
    // A progress dialog to display when the user is connecting in
    // case there is a delay in any of the dialogs being ready.
    private ProgressDialog mConnectionProgressDialog;
    //-------------for google sign in
    /* Is there a ConnectionResult resolution in progress? */
    private boolean mIsResolving = false;

    /* Should we automatically resolve ConnectionResults when possible? */
    private boolean mShouldResolve = false;
    private static final int RC_SIGN_IN = 10101;
    //---------Firebase
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_boolax_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        //----------Hide Actionbar----------

        Boolax_login = (FancyButton) findViewById(R.id.Boolax_normal_login);
        //------------
        Boolax_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_login.this, Boolax_favorite_Boo_Booers.class);
                startActivity(i);
            }
        });
        //------------------
        Boolax_facebook = (LoginButton) findViewById(R.id.Boolax_facebook);
        Boolax_facebook.setReadPermissions(Arrays.asList(EMAIL));
        //---------Facebook call back
        callbackManager = CallbackManager.Factory.create();
        //---
        Boolax_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHashkey();
                boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
                if (!loggedIn) {
                    //LoginManager.getInstance().logInWithReadPermissions(Boolax_login.this, Arrays.asList("public_profile"));
                    LoginManager.getInstance().logInWithReadPermissions(Boolax_login.this, Arrays.asList("user_about_me", "user_birthday", "user_location", "email"));
                }
            }
        });
        //----Call back functions
        Boolax_facebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                System.out.println("onSuccess");
                mConnectionProgressDialog = new ProgressDialog(Boolax_login.this);
                mConnectionProgressDialog.setMessage("Processing data...");
                mConnectionProgressDialog.show();
                String accessToken = loginResult.getAccessToken().getToken();
                Log.i("accessToken", accessToken);

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.i("LoginActivity", response.toString());
                        mConnectionProgressDialog.dismiss();
                        // Get facebook data from login
                        Bundle bFacebookData = getFacebookData(object);
                        //-----
                        Profile profile = Profile.getCurrentProfile();
                        String id = profile.getId();
                        String link = profile.getLinkUri().toString();
                        //----------
                        String birthdate = null;

                        birthdate = bFacebookData.getString("birthday");



                        //----
                        Uri profile_pic = null;
                        if (Profile.getCurrentProfile() != null) {
                            Log.i("Login", "ProfilePic" + Profile.getCurrentProfile().getProfilePictureUri(200, 200));
                            profile_pic = Profile.getCurrentProfile().getProfilePictureUri(200, 200);
                        }
                        new Boolax_server_requests_and_local(Boolax_login.this, Config.BOOLAX_FAVORITE_SAVE_SOCIAL_MEDIA_LOG_CREDS.toString(), (bFacebookData.getString("first_name") != null) ? bFacebookData.getString("first_name") : "", (bFacebookData.getString("email") != null) ? bFacebookData.getString("email") : "", id, "google_api", bFacebookData.getString("gender"), birthdate, (profile_pic.toString() != null) ? profile_pic.toString() : "", "facebook_api").execute();

                        // Toasty.success(Boolax_login.this, "" + bFacebookData.getString("email"), Toast.LENGTH_SHORT, true).show();

                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email,gender, birthday, location"); // Parámetros que pedimos a facebook
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toasty.error(Boolax_login.this, "" + exception.toString(), Toast.LENGTH_SHORT, true).show();

            }
        });


        //------------Firebase

        Boolax_google = (SignInButton) findViewById(R.id.Boolax_google);
        //-------------google sign in
        // First we need to configure the Google Sign In API to ensure we are retrieving
        // the server authentication code as well as authenticating the client locally.
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestId()
                .requestEmail()
                .requestScopes(new Scope(Scopes.PROFILE))
                .requestScopes(new Scope(Scopes.PLUS_LOGIN))
                .build();
        //-----------------------------
        mGoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addApi(Plus.API)
                .build();
        mConnectionProgressDialog = new ProgressDialog(this);
        mConnectionProgressDialog.setMessage("Signing in...");
        //-----------------
        Boolax_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Tapped sign in");
                // Show the dialog as we are now signing in.
                mConnectionProgressDialog = new ProgressDialog(Boolax_login.this);
                mConnectionProgressDialog.setMessage("Signing in...");
                mConnectionProgressDialog.show();
                //--------------
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
                //---------


            }
        });
        //---------------------Launch other activities----------
        FancyButton boolax_create_an_account = (FancyButton) findViewById(R.id.boolax_create_an_account);
        FancyButton boolax_create_forgot = (FancyButton) findViewById(R.id.boolax_create_forgot);
        //---------
        boolax_create_an_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_login.this, boolax_basic_profile.class);
                startActivity(i);

            }
        });
        //-----------------
        boolax_create_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_login.this, Forgot_Password.class);
                startActivity(i);

            }
        });


    }
    //--------Google login tools----------

    /**
     * Global instance of the HTTP transport.
     */

    //------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        Log.v(TAG, "ActivityResult: " + requestCode);

        if (requestCode == OUR_REQUEST_CODE) {
            // Hide the progress dialog if its showing.
            mConnectionProgressDialog.dismiss();

        }
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            mConnectionProgressDialog.dismiss();
            //GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //handleSignInResult(result);
            //----------------------
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            int statusCode = result.getStatus().getStatusCode();
            //----------

            mGoogleApiClient.connect();

            if (result.isSuccess()) {
                //------------
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                ///------------------
                if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {

                    if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
                        Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                        String personName = currentPerson.getDisplayName();
                        String personEmail = account.getEmail();
                        String personPhoto = currentPerson.getImage().getUrl();
                        String personGooglePlusProfile = currentPerson.getUrl();
                        String birthday = currentPerson.getBirthday();
                        String user_id = currentPerson.getId();
                        int gender = currentPerson.getGender();
                        //-------------
                        new Boolax_server_requests_and_local(Boolax_login.this, Config.BOOLAX_FAVORITE_SAVE_SOCIAL_MEDIA_LOG_CREDS.toString(), (personName != null) ? personName : "", (personEmail != null) ? personEmail : "", (user_id != null) ? user_id : "", "google_api", (gender == 1) ? "female" : "male", (birthday != null) ? birthday : "", (personPhoto != null) ? personPhoto : "", "google_api").execute();
                        Toasty.success(Boolax_login.this, "Data here" , Toast.LENGTH_SHORT, true).show();

                    }
                } else {
                    Toasty.error(Boolax_login.this, "Network Error! Try Again!", Toast.LENGTH_SHORT, true).show();


                }

            } else {
                Toasty.error(Boolax_login.this, "Failed!" , Toast.LENGTH_SHORT, true).show();

            }
        }

    }

    //----------Gmail authenticate--
    private void handleSignInResult_(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            // Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());

        }
    }
    //---------

    private boolean mResolvingError = false;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (!mResolvingError) {  // more about this later
            mGoogleApiClient.connect();
        }


    }

    private static final int REQUEST_RESOLVE_ERROR = 1001;

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult result) {
        // When we get here in an automanager activity the error is likely not
        // resolvable - meaning Google Sign In and other Google APIs will be
        // unavailable.
        if (mResolvingError) {
            // Already attempting to resolve an error.
            return;
        } else if (result.hasResolution()) {
            try {
                mResolvingError = true;
                result.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
            } catch (IntentSender.SendIntentException e) {
                // There was an error with the resolution intent. Try again.
                mGoogleApiClient.connect();
            }
        } else {
            // Show dialog using GooglePlayServicesUtil.getErrorDialog()
            mResolvingError = true;
        }
    }


    /**
     * Helper method to trigger retrieving the server auth code if we've signed in.
     */
    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            // If you don't already have a server session, you can now send this code to your
            // server to authenticate on the backend.


            String authCode = acct.getServerAuthCode();
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();

            }

        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void getHashkey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());

                Log.i("Base64", Base64.encodeToString(md.digest(), Base64.NO_WRAP));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("Name not found", e.getMessage(), e);

        } catch (NoSuchAlgorithmException e) {
            Log.d("Error", e.getMessage(), e);
        }
    }

    //-----------
    private Bundle getFacebookData(JSONObject object) {

        try {
            Bundle bundle = new Bundle();
            String id = object.getString("id");

            try {
                URL profile_pic = new URL("https://graph.facebook.com/" + id + "/picture?width=200&height=150");
                Log.i("profile_pic", profile_pic + "");
                bundle.putString("profile_pic", profile_pic.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }

            bundle.putString("idFacebook", id);
            if (object.has("first_name"))
                bundle.putString("first_name", object.getString("first_name"));
            if (object.has("last_name"))
                bundle.putString("last_name", object.getString("last_name"));
            if (object.has("email"))
                bundle.putString("email", object.getString("email"));
            if (object.has("gender"))
                bundle.putString("gender", object.getString("gender"));
            if (object.has("birthday"))
                bundle.putString("birthday", object.getString("birthday"));
            if (object.has("location"))
                bundle.putString("location", object.getJSONObject("location").getString("name"));

            return bundle;
        } catch (JSONException e) {
            Log.d(TAG, "Error parsing JSON");
        }
        return null;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}