package nyc.c4q.huilin.retrofitchucknorris.network;

import nyc.c4q.huilin.retrofitchucknorris.model.SendMessageResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by huilin on 10/23/16.
 */

public interface SlackService {

    // "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&as_user=true" + "&text=" + messageText);

    @POST("chat.postMessage")
    Call<SendMessageResponse> sendMessage(@Query("token") String token, @Query("channel") String channel, @Query("as_user") String asUser, @Query("text") String messageText);
}
