import ViewControllers.ChatActivityModule;
import dagger.Module;

/**
 * Created by Amaury Esparza on 02/10/2014.
 */

@Module(
        injects = App.class,
        includes = ChatActivityModule.class

)
public class AppModule {


}
