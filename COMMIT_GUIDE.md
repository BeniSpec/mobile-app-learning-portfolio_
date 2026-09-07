# Commit Message & Git Workflow Guide

> Delete this file before final submission, or keep it — it doesn't hurt your grade either way, but it's here so you have a quick reference while you work. "Version Control Practices" is worth 10% of your total grade, and it's graded on *frequency + message quality*, not code perfection.

## The basic loop, every time you finish a piece of work

```bash
git add .
git commit -m "Implement Login Screen using Compose"
git push
```

Do this **after every lab exercise or meaningful chunk of work** — not once at the end of each module, and definitely not once at the end of the semester.

## Good vs bad commit messages

| ❌ Avoid | ✅ Use instead |
|---|---|
| Update | Add ViewModel implementation for counter app |
| Fix | Fix null pointer exception in LazyColumn item click |
| Final | Complete Unit 1 Pathway 3 lab exercise |
| Test | Write unit test for calculateTotal() function |
| asdf / wip | Refactor UI using Material Design 3 |

**Rule of thumb:** a good commit message finishes the sentence *"This commit will..."* — e.g. "...add a button to the app UI", "...implement navigation between two screens".

## Suggested commit rhythm per module

1. `Set up Module-X folder structure`
2. `Complete [specific lab exercise name]` (repeat per exercise)
3. `Add screenshots for [exercise name]`
4. `Add badge evidence for [badge name]` (repeat per badge)
5. `Write initial analysis draft for Module X`
6. `Refine Module X analysis with technique comparison`

Spreading these across several days (matching when you actually did the work) is exactly what "continuous learning" evidence looks like to a grader glancing at your commit history graph.

## First-time setup (if you're new to Git)

```bash
git clone https://github.com/[your-username]/mobile-app-learning-portfolio.git
cd mobile-app-learning-portfolio
# ...add/edit files...
git add .
git commit -m "Your message here"
git push origin main
```
