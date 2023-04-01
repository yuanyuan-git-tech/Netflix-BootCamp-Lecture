# Record Collection Repositories

In this activity, you'll create repositories for the `record-collection` project. You'll also create unit tests for the repositories.

## Instructions

1. Open the [starter project](./starter/record-collection/pom.xml) in IntelliJ.

2. Add a new `repository` package to the project, and create repositories for the following models:

   - `Album`

   - `Artist`

   - `Label`

   - `Track`

3. Add a new `repository` package to the `test` folder.

4. Create tests for each repository. Following good TDD practices, we know that in the future we will want the following basic CRUD methods in our controllers for each repository:

   - Get All

   - Get By Id

   - Add

   - Update

   - Delete

5. Create tests to support the following custom query methods:

   - Find an album by title.

   - Find an artist by name.

   - Find all tracks by album id.

   - Find a track by name.

6. Finally, add repository methods to match the tests you wrote above.

---

© 2023 2U. All Rights Reserved.
