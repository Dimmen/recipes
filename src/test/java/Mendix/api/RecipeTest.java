package Mendix.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class RecipeTest {
    private static String recipeJson="    {\n" +
            "      \"head\": {\n" +
            "        \"title\": \"30 Minute Chili\",\n" +
            "        \"categories\": {\n" +
            "          \"cat\": [\n" +
            "            \"Main dish\",\n" +
            "            \"Chili\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"yield\": \"6\"\n" +
            "      },\n" +
            "      \"ingredients\": {\n" +
            "        \"ing\": [\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"pound\"\n" +
            "            },\n" +
            "            \"item\": \"Ground chuck or lean ground; beef\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"\"\n" +
            "            },\n" +
            "            \"item\": \"Onion; large, chopped\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"can\"\n" +
            "            },\n" +
            "            \"item\": \"Kidney beans; (12 oz)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"can\"\n" +
            "            },\n" +
            "            \"item\": \"Tomato soup; undiluted\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"teaspoon\"\n" +
            "            },\n" +
            "            \"item\": \"Salt\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"1\",\n" +
            "              \"unit\": \"tablespoon\"\n" +
            "            },\n" +
            "            \"item\": \"Chili powder; (or to taste)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"amt\": {\n" +
            "              \"qty\": \"\",\n" +
            "              \"unit\": \"\"\n" +
            "            },\n" +
            "            \"item\": \"Hot pepper sauce; to taste\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"directions\": {\n" +
            "        \"step\": \"  Brown the meat in a little butter and cook until the meat is brown -- about\\n  10 minutes. Add all other ingredients and let simmer for 30 minutes. Your\\n  choice of hot sauce may be added to taste.\\n  \\n  Recipe by: MasterCook Archives\\n  \\n  Posted to recipelu-digest Volume 01 Number 577 by Rodeo46898\\n  <Rodeo46898@aol.com> on Jan 22, 1998\\n \\n\"\n" +
            "      }\n" +
            "    }";

    @Test
    public void testJSONConversionToRecipe() throws IOException{

        ObjectMapper mapper = new ObjectMapper();
        Recipe obj = mapper.readValue(recipeJson, Recipe.class);
        assertNotNull(obj != null);

    }
}
