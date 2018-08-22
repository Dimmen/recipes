package Mendix;

import Mendix.resources.RecipesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MendixRecipesApplication extends Application<MendixRecipesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MendixRecipesApplication().run(args);
    }

    @Override
    public String getName() {
        return "MendixRecipes";
    }

    @Override
    public void initialize(final Bootstrap<MendixRecipesConfiguration> bootstrap) {
    }

    @Override
    public void run(final MendixRecipesConfiguration configuration,
                    final Environment environment) {
        final RecipesResource resource = new RecipesResource();
        environment.jersey().register(resource);
    }

}

