# Our workflow and work habits

Since day one, we have made certain choices in order to work on our project in an efficient way. These choices are in many ways inspired by SCRUM - a framework for agile project management and product development. We see each iteration (release) as a sprint, where we work on developing our application further.

## 1. Workflow

### Planning

Planning has been an important part in developing our application in order to work in a well-organized and structured way towards our goals. We started by having a conversation where we shared our thoughts on important topics such as how much time we wanted to dedicate to the project, our ambitions in the subject and expectations towards each other. This conversation accumulated into a group contract, which we all signed. Even though the whole group were friends from before and knew each other, having a group contract is critical in order to secure a positive working environment with clear expectations and in order to reduce the risk of conflict.

After having decided that our project was going to be PacMan and having this idea approved by our Teaching Assistant, we started brainstorming how we wanted to shape our application: which features we wanted to implement, ideas to how we could transform these features into code and delegating tasks. Planning has continued beeing an important part of our workflow through all 3 releases of the application.

<br>

### Group meetings

A typical week for the group has usually consisted of three group meetings; on Monday, on Tuesday and on Thursday. These meetings lasted for about 2 hours, but of course we adjusted this from week to week so it matched the workload. Often we ended up sitting for many hours after these meetings, working on the project together.

We always started our Monday meetings by talking about what remained to be done before the next due date and what we planned to get done that specific week. In this way, we split all the chores connected to a release into smaller pieces, which made them more manageable and easier to handle.

At the beginning of all meetings, we started by giving a status report on what we were working on and how it was going. This was inspired by "The Daily Scrum" in SCRUM. In addition, we wrote a small report from each meeting that summarized what we have talked about in short. These reports were saved in our shared TeamSpace in Notion, where we also kept track on deadlines and which criterias each deliverable had. This made it easy for all team members to look back on what we had discussed and agreed upon, for instance if someone was not able to participate on a group meeting.

<br>

### Retrospective and reflection

In the first meetings after we had delivered a release, the group reflected together upon the previous sprint as the "Sprint Retrospective" in SCRUM suggests. We talked about what had worked well, and where we saw room for improvements. We then brought these reflections into the next sprint, in order to improve how we worked together as a team.

<br>

### LiveShare and pair programming

During the project, we chose to not use LiveShare that much, because we experienced it as quite buggy. Also, if we ran the tests and they failed, we often needed to restart VSCode or the computer itself. This led to the LiveShare session being cut off and we had to spend a lot of time reconnecting. In short, it became more of a disadvantage rather than an advantage and therefore we stepped away from it.

However, we often used co-programming and generally cooperated on issues. The advantage of this was that while one person was programming, the other could think ahead and scout out possible problems or solutions to future parts of the commit. When this technique was used, we made sure to include Co-Authored-by#name in the footer of the commit message.

<br>

### Asking for help

This subject has introduced us to many new concepts and technologies, and to create a project with technologies you are not that experienced with can be challenging. We have encountered many frustrating problems and errors along the way, and we have definitely learned the importance of asking for help when struggling with something.

When facing problems, we usually followed these steps in an attempt to solving them:

``` none
1. Ask the other group members for help

2. Ask other groups for help, often they had encountered similar problems

3. Browse piazza and the internet for solutions

4. Ask our Teaching Assistant

5. Reach out to the Technical Assistence channel on Teams
```

## 2. Work habits

When it comes to work habits, we have used GitLab frequently in order to keep track of the development of our application. We have made use of GitLab's features for collaboration on projects such as:

- Milestones
- Labels
- Issues
- Tasks
- Branches
- Commits
- Merge requests
- Reviews

## Our work cycle in short

1. A milestone for a release and belonging issues with appropriate labels are created

2. An issue is chosen and assigned to ourselves, individually or in teams

3. A branch for that issue is created

4. We work on the issue, make commits with messages to the branch and push to the branch. This is repeated until we feel that the issue has been resolved

5. Create a merge request for the issue

6. Wait for others to review and approve the merge request, make changes if necessary

7. Potential merge conflicts are resolved, the branch is merged into master, and the issue is closed

-> Start at  nr. 2 again, and repeat until all issues assigned to that milestone are closed

The different parts of the cycle are described more detailed below.

## Our work cycle in detail

### Milestones, labels and issues

At the beginning of each iteration, we have started by creating a new Milestone for that very iteration. This has been followed by a conversation about what needs to be done for the release; what are the new demands and which new features do we want to implement. Based on this conversation, we have created issues assigned to the Milestone. We have tried to create as many issues as we can at the beginning of each release, but we also add issues along the way if we discover something that needs to be done or fixed.

<br>

**Our milestones:**

1. Release 1: Implement basic PacManFeatures
2. Release 2: Improved modular application
3. Release 3: Final release

<br>

**We have also created these Labels:**

- Minor
- Moderate
- Critical
- Bug

<br>

Each issue is assigned with the appropriate label(s), stating its type and priority. This makes it easier for us to ensure that the application fulfills all requirements given. It also decreases the amount of time we spend on choosing an issue, because we can easily see which issues are the most important to get done.

#### Tasks

In the 3rd release, we also started using tasks, which is a feature from GitLab allowing us to divide issues into smaller parts. Since an issue often holds many smaller chores, many tasks can be added to an issue, and each task gets a unique #nr. In the earlier releases we often experienced that a commit solved part of an issue, but not the whole issue itself. This led to many small commits or very large ones that had many changes in them, and it could be a bit chaotic to see what each commit did.

Tasks solved this problem, since they allowed us to link commits directly to tasks by mentioning their #nr in the commit message. Additionally they provide structure to each issue, making it easy to see which chores they contain.

<br>

### Assigning issues and creating branches

Once we had agreed upon our goals for a release and created issues, we started to assign issues in order to actually get them done. We usually chose which issue we wanted to work on freely, and whether we wanted to work alone or together. After deciding on an issue, we assigned it to ourselves, in order to avoid two people working on the same problem without knowing about it. We then created a new branch in order to keep the code connected to different issues separate. This contributed to a cleaner code and workflow.

In week 39 we learned from the lecture that branches connected to issue nr.#, should be named "#-what-is-fixed". Since we did not know about this from scratch, we started following this naming-convention in the middle of release2. However, we do see the advantages of it - it makes it a lot easier to see what is being done in each branch and it is easier to switch between branches quickly.

<br>

### Commits, pushing and merge requests

In the process of working on an issue, we added our changes to the staging area and usually committed our changes at the end of a working session. We made sure to write a commit message in imperative, to make it easy for the others to see what a commit did and to avoid confusion and uncertainty. The commit messages consist of a headline which summarizes the changes, a body for more detail, and a footer with the related issue and possible co-authors.

We also pushed to the issue-branch, when we considered the code (or part of the code) "done". In this way, others could checkout that branch, pull and for instance assure that everything iworked as it should. When we were completely done with an issue, we created a merge request that requested to merge the branch into master. In the merge request, we made sure to write which changes the branch would add to master as well as which issue it closed or was related to with an #issue-number. We also made sure that the merge request had the correct label and milestone, and that it was assigned to the assignee of the issue.

<br>

### Approving and merging

Once a merge request was created, we asked the others to review it and give feedback on the code. The others took a look at the changes done, and added comments if they had any questions or suggested improvements. When it had been approved by at least one of the others and potential changes had been made, we solved any merge conflicts and merged the branch with master before closing the issue. We then started at the top again by choosing a new issue, and repeated the whole process.

## Reflection

We feel that this workflow and these work habits have worked out well for us. The milestones, issues and labels have provided a great overview of the application and have helped us keeping track of tasks, who is working with what and in general keep track on where we are on everything. The group meetings have contributed to enhancing the group feeling; we made important decisions regarding the application's future together - and we all had the possibility to impact the application. We usually sat together at campus when we were working, which made discussing and asking others for help very accessible. In addition, we shared information, opinions and ideas. The group meetings also ensured that everyone had the same vision of how the deliverable would turn out.

Looking back, we are very happy with our group dynamic, our workflow and work habits. We definitely have learned a lot about team work and everything that comes with it from this project.