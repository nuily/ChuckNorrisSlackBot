package nyc.c4q.huilin.retrofitchucknorris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import nyc.c4q.huilin.retrofitchucknorris.model.ChuckNorrisJoke;
import nyc.c4q.huilin.retrofitchucknorris.model.SendMessageResponse;
import nyc.c4q.huilin.retrofitchucknorris.network.ChuckNorrisService;
import nyc.c4q.huilin.retrofitchucknorris.network.SlackService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChuckNorrisActivity extends AppCompatActivity {
    private static final String TAG = ChuckNorrisActivity.class.getName();
    private TextView chuckTV;
    private final String API_KEY = BuildConfig.API_KEY;
    private final String BASE_URL = "https://slack.com/api/";
    private final String ENDPOINT_TEST = "api.test";
    private final String ENDPOINT_USER = "users.info";
    private final String ENDPOINT_LIST_CHANNELS = "channels.list";
    private final String ENDPOINT_LIST_MESSAGES = "channels.history";
    private final String ENDPOINT_POST_MESSAGE = "chat.postMessage";
    private final String ENDPOINT_DELETE_MESSAGE = "chat.delete";
    private final String BOTS_CHANNEL_ID = "C2ABKERFT";
    private final String MESSYBOT_CHANNEL_ID = "C2ADPS5MK";
    private final String ASUSER = "true";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuck_norris);

        chuckTV = (TextView) findViewById(R.id.tv_chuck);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
        Call<ChuckNorrisJoke> call = service.getRandomJoke();

        call.enqueue(new Callback<ChuckNorrisJoke>() {
            @Override
            public void onResponse(Call<ChuckNorrisJoke> call, Response<ChuckNorrisJoke> response) {
                try {
                    if (response.isSuccessful()) {
                        ChuckNorrisJoke joke = response.body();
                        chuckTV.setText(joke.getValue());
                        message = (joke.getValue());
                        angry(message);
                        Log.d(TAG, "Success: " + response.body().getValue());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ChuckNorrisJoke> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

    public void angry(String message) {
        Retrofit slackRetrofit = new Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SlackService slackService = slackRetrofit.create(SlackService.class);
        Call<SendMessageResponse> slackCall = slackService.sendMessage(API_KEY, BOTS_CHANNEL_ID, ASUSER, message);

        slackCall.enqueue(new Callback<SendMessageResponse>() {
            @Override
            public void onResponse(Call<SendMessageResponse> call, Response<SendMessageResponse> response) {
                // idk
            }

            @Override
            public void onFailure(Call<SendMessageResponse> call, Throwable t) {

            }
        });
    }
}
