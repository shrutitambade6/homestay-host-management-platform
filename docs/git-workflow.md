# Git Workflow

## Branches

| Branch | Purpose | Who writes to it |
| --- | --- | --- |
| `main` | Stable, demo-ready code; CI builds release images from it | Pull request from `develop` at sprint end only |
| `develop` | Integration of finished features during a sprint | Pull requests from work branches |
| `feature/*`, `fix/*`, `docs/*`, `test/*`, `chore/*` | One piece of work each; deleted after merge | The developer who owns the issue |

## Branch naming rules

Format: `<type>/<short-description>`

- lowercase letters, digits and hyphens only
- 2–5 words, describing the work
- no spaces, no personal names, no vague words (`new`, `changes`, `stuff`, `final`, `test1`)

Examples: `feature/property-management`, `feature/booking-api`, `fix/booking-validation`, `docs/setup-guide`, `test/authentication-tests`, `chore/docker-setup`.

## Commit messages

Format: `type: short description` — imperative mood, lower case, no full stop, about 50 characters or fewer.

| Type | Use for | Example |
| --- | --- | --- |
| `feat` | New MVP functionality | `feat: add booking creation endpoint` |
| `fix` | Bug fix | `fix: reject overlapping booking dates` |
| `docs` | Documentation only | `docs: update local setup instructions` |
| `test` | Adding or changing tests | `test: add booking service tests` |
| `refactor` | Code change with no behaviour change | `refactor: extract overlap check to service` |
| `build` | Maven, dependencies, Dockerfiles | `build: add PostgreSQL driver` |
| `ci` | GitHub Actions workflows | `ci: add automated test workflow` |
| `chore` | Repository housekeeping | `chore: add GitHub issue templates` |

Reference the issue in the body when there is one: `Refs #12` (or `Closes #12` in the pull request).

One logical change per commit. Messages such as `changes`, `update`, `final`, `done` are not accepted in review.

## Daily cycle

```powershell
git checkout develop
git pull
git checkout -b feature/property-management
# ...work, then:
git add .
git commit -m "feat: add property creation endpoint"
git push -u origin feature/property-management
# open a pull request into develop on GitHub
```

After the pull request is merged:

```powershell
git checkout develop
git pull
git branch -d feature/property-management
```
