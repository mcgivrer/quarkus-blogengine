Feature: Create, update, archive and delete a Blog

    As a new user or an existing one, I want to create my own Blog

Scenario: Create a Blog
    Given the service is up and ready
    When a new user "McGivrer" create an account
    And want to create a new Blog "My Own Blog"
    Then the blog is created with a technical Id
    And a first default post "Your first post" is automaticaly created

Scenario: Update a Blog
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And Start a new Post 
    And set title as "My second post"
    And set content as "this is my first real post about devops"
    And set tags as "news,devops"
    And save the post
    Then the post is created with a new UUID and the current date.

Scenario: Archive a blog
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And the blog is archived
    Then the blog "My Own Blog" has no more public access

Scenario: Delete a Blog
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And the blog is deleted
    Then blog is deleted and no more accessible by anybody.