# MendixRecipes (a Dropwizard application)

How to start the MendixRecipes application
---

1. Run `mvn clean package` to build your application
1. As the application is package, JUNIT runs test. You can manually run the test via 'mvn test'.
1. Start application with `java -jar target/recipes-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`
1. The config.yml can be used the change for example the port


Usage
---

All endpoints accept application/json. Below is an overview of all the api's. All the Http status code's are according to the industry standards.

API:
| Command | Path | Example | Description |
| --- | --- | --- | --- |
| GET | /recipes | Get all recipes | http://localhost:8080/recipes |
| GET | /recipes/category | Get all categories | http://localhost:8080/recipes/category |
| GET | /recipes/filter | Filters the recipes on category | http://localhost:8080/recipes/filter?filter=Italian |
| GET |  /recipes/id  | Get 1 recipe based on id(title) | http://localhost:8080/recipes/id?id=Pizza |
| GET | /recipes/search | Search on category or name | http://localhost:8080/recipes/search?search=Piz |
| POST |  /recipes | Adds a new recipe to the memory | http://localhost:8080/recipes |

Example JSON format for posting:

	

	{
      "head": {
        "title": "taart",
        "categories": {
          "cat": [
            "Italian",
            "Cheese",
            "Spicy"
          ]
        },
        "yield": "6"
      },
      "ingredients": {
        "ing": [
          {
            "amt": {
              "qty": "1",
              "unit": "pound"
            },
            "item": "Ground chuck or lean ground; beef"
          },
          {
            "amt": {
              "qty": "1",
              "unit": ""
            },
            "item": "Onion; large, chopped"
          },
          {
            "amt": {
              "qty": "1",
              "unit": "can"
            },
            "item": "Kidney beans; (12 oz)"
          },
          {
            "amt": {
              "qty": "1",
              "unit": "can"
            },
            "item": "Tomato soup; undiluted"
          },
          {
            "amt": {
              "qty": "1",
              "unit": "teaspoon"
            },
            "item": "Salt"
          },
          {
            "amt": {
              "qty": "1",
              "unit": "tablespoon"
            },
            "item": "Chili powder; (or to taste)"
          },
          {
            "amt": {
              "qty": "",
              "unit": ""
            },
            "item": "Hot pepper sauce; to taste"
          }
        ]
      },
      "directions": {
        "step": "  Brown the meat in a little butter and cook until the meat is brown -- about  10 minutes. Add all other ingredients and let simmer for 30 minutes. Your choice of hot sauce may be added to taste. Recipe by: MasterCook Archives  Posted to recipelu-digest Volume 01 Number 577 by Rodeo46898  <Rodeo46898@aol.com> on Jan 22, 1998"
      }
    } 

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
