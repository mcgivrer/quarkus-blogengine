Feature: Create, update, publish, archive and delete a post
        
    A user "McGiver" is creating, modifying and delete a post from its blog "My Own Blog".

Scenario: Create a Post
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And Start a new Post 
    And set title as "My second post"
    And set content as "this is my first real post about devops"
    And set tags as "news,devops"
    And set categories as "life"
    And save the post as draft
    Then the post is created with a new UUID
    And the post state is set to "draft"
    And the createdAt date is set to current date.

Scenario: Validate an existing Post
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And select the post with title as "My second post"
    And publish the post
    Then the post state is set to "validated"
    And the updatedAt date is set to current date.

Scenario: Publish an existing Post
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And select the post with title as "My second post"
    And publish the post
    Then the post state is set to"published"
    And the updatedAt date is set to current date.

Scenario: Update a Post
    Given the service is up and ready
    And the user "McGivrer" is connected to his blog "My Own Blog"
    And Start a new Post 
    And set title as "My second post"
    And set content as "this is my first real post about devops"
    And set tags as "news,devops"
    And save the post
    Then the post state is set to"published"
    And the updatedAt date is set to current date.
