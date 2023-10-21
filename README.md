# basketball-roster-api

## API List
See Swagger (springdoc-openapi v2.2.0)

| Phase  | Url                                         |
|--------|---------------------------------------------|
| Local  | http://localhost:8080/swagger-ui/index.html |


## Develop
This project written by kotlin with spring boot 3.x.

### Kotlin lint
Run below gradle tasks for add lint check before commit.
- addKtlintCheckGitPreCommitHook
- ktlintApplyToIdea
Lint check will be performed before commit or build. If you struggled with correct, run ktlintFormat gradle task. It will fix automatically.

### Test
Repository test run with test containers. So, you need docker environment like Docker Desktop. Please be sure docker process started before start repository test.
