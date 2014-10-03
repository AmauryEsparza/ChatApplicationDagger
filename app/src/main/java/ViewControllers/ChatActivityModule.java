package ViewControllers;

import BussinessControllers.FriendChatBussinessController;
import BussinessControllers.IChatRepresentationDelegate;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */
@Module
public class ChatActivityModule {

    @Provides public IChatRepresentationDelegate provideFriendChat(){
        return new FriendChatBussinessController();
    }
}
