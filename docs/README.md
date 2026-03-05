# Jeff the Chatbot 🦈: User Guide
## Overview
Welcome to my task tracking chatbot, Jeff, that remembers your events, deadlines and todo.
> **BEWARE:** Jeff ain't your fruity chatbot that talks to you nice when you make mistakes.

If you think Jeff is a regular name, you lack **_ball knowledge_**, mynameJeff.✌🏽

## Table of Contents:
- [Quick Start](#quick-start)
- [Features](#features)
    - [Viewing help: `help`](#viewing-help-help)
    - [Add Todo task: `todo`](#add-todo-task-todo)
    - [Add Deadline task: `deadline`](#add-deadline-task-deadline)
    - [Add Event task: `event`](#add-event-task-event)
    - [List of tasks: `list`](#list-of-tasks-list)
    - [Mark a task: `mark`](#mark-a-task-mark)
    - [Unmark a task: `unmark`](#unmark-a-task-unmark)
    - [Deleting a task: `delete`](#deleting-a-task-delete)
    - [Finding a task: `find`](#finding-a-task-find)
    - [Exiting the program: `bye`](#exiting-the-program-bye)
- [Saving the Data](#saving-the-data)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)
- [Collaboration](#collaboration)

## Quick Start
1. Ensure that you have Java 17 or above installed on your computer.
2. Download the latest `.jar` file for Jeff.
3. Copy the file to the folder that you want to use as the home folder for your Task Manager.
4. Open Terminal (Mac) or Windows PowerShell (Windows), `cd` into the folder you put the jar file in, and use the `java -jar Jeff.jar` command to run the application.
5. If you are starting fresh, you should see the following greeting:
<pre><code> no saved tasks file—starting fresh.
____________________________________________________________
Hello, myname jeff
       __  _______  _______  _______
      |   ||      ||       ||       |
      |   ||    __||    ___||    ___|
      |   ||   |__ |   |___ |   |___
   ___|   ||    __||    ___||    ___|
  |       ||   |___|   |    |   |
  |_______||_______|___|    |___|
What can I do for you?
____________________________________________________________</code></pre>
6. Type a command in the command line and press Enter to execute it.
   (e.g., typing `help` and pressing Enter will open the help menu.)
7. Refer to the [Features](#features) below for details of each command.

## Features

> **Note on Indexing:** Jeff uses **0-based indexing**. When referring to a task number for commands like `mark`, `unmark`, or `delete`, the first task in the list is `0`, the second is `1`, and so on.

### Viewing help: `help`
Shows instructions on how to use Jeff and the format for his commands.
<br>
<b> Format: </b> `help` <br>
<b> Example: </b> `help` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 this guy can't remember nothing. here is a list of what i can do:
  1. todo <description> : adds a basic todo task.
  2. deadline <description> /by <time> : adds a deadline task.
  3. event <description> /from <start> /to <end> : adds an event.
  4. list : shows all your tasks.
  5. mark <index> : marks a task as done.
  6. unmark <index> : unmarks a task.
  7. delete <index> : delete a task.
  8. find <keyword> : searches for a task.
  9. help : you are looking at it.
  10. bye : if you wanna leave the app.

 don't make me repeat myself.
~~~

### Add Todo task: `todo`
Adds a basic task without a date.
<br>
<b> Format: </b> `todo DESCRIPTION` <br>
<b> Example: </b> `todo read book` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 sheeshh. new task. ok added:
   [T][ ] read book
 now you have 1 task in your list!
____________________________________________________________
~~~

### Add Deadline task: `deadline`
Adds a task with a deadline. (If you forget the `/by` parameter, Jeff will auto-fill it with `tbd`).
<br>
<b> Format: </b> `deadline DESCRIPTION /by DATE` <br>
<b> Example: </b> `deadline submit report /by monday` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 shagg. need to get this done asap. ok added:
   [D][ ] submit report (by: monday)
 now you have 2 tasks in your list!
____________________________________________________________
~~~

### Add Event task: `event`
Adds a task with a time range. (If you forget the `/from` or `/to` parameters, Jeff will auto-fill them with `tbd`).
<br>
<b> Format: </b> `event DESCRIPTION /from START /to END` <br>
<b> Example: </b> `event project meeting /from 2pm /to 4pm` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 new event! ok added:
   [E][ ] project meeting (from: 2pm to: 4pm)
 now you have 3 tasks in your list!
____________________________________________________________
~~~

### List of tasks: `list`
Displays all tasks currently being tracked by Jeff.
<br>
<b> Format: </b> `list` <br>
<b> Example: </b> `list` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 0. [T][ ] read book
 1. [D][ ] submit report (by: monday)
 2. [E][ ] project meeting (from: 2pm to: 4pm)
____________________________________________________________
~~~

### Mark a task: `mark`
Mark a task as completed using its 0-based index.
<br>
<b> Format: </b> `mark TASK_INDEX`<br>
<b> Example: </b> `mark 3` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 niceee, i have marked this task done:
 [D][X] another deadline (by: tbd)
____________________________________________________________
~~~

### Unmark a task: `unmark`
Mark a completed task as not done yet using its 0-based index.
<br>
<b> Format: </b> `unmark TASK_INDEX`<br>
<b> Example: </b> `unmark 2` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 ok, i have marked this task as not done yet:
 [E][ ] project meeting (from: 2pm to: 4pm)
____________________________________________________________
~~~

### Deleting a task: `delete`
Deletes a task from the list using its 0-based index.
<br>
<b> Format: </b> `delete TASK_INDEX`<br>
<b> Example: </b> `delete 1` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
 noted, following task has been deleted:
  [D][ ] submit report (by: monday)
 now you have 6 tasks in the list.
____________________________________________________________
~~~

### Finding a task: `find`
Finds a task by a keyword in its description.
<br>
<b> Format: </b> `find KEYWORD`<br>
<b> Example: </b> `find book` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
here are the matching tasks in your list:
 0. [T][ ] read book
____________________________________________________________
~~~

### Exiting the program: `bye`
Closes Jeff and automatically saves your tasks to the hard drive.
<br>
<b> Format: </b> `bye` <br>
<b> Example: </b> `bye` <br>
<b> Expected Output: </b>
~~~text
____________________________________________________________
bye bye. safe man.
____________________________________________________________
~~~

## Saving the data
Data is stored under <b> `data/tasks.txt` </b>.

## FAQ
There is currently nothing here! Watch this space for any updates.

## Known Issues
Currently, there are no known issues. If you type nonsense, Jeff will handle it and will inform you, politely.  
If any spotted, please do drop me an email at [Email](mailto:vetrik10@gmail.com)

## Command Summary

| Action | Format, Examples |
|--------|------------------|
| Add Todo | `todo DESCRIPTION` <br> e.g. `todo read book` |
| Add Deadline | `deadline DESCRIPTION /by DATE` <br> e.g. `deadline submit report /by monday` |
| Add Event | `event DESCRIPTION /from START /to END` <br> e.g. `event project meeting /from 2pm /to 4pm` |
| List | `list` |
| Mark | `mark TASK_INDEX` <br> e.g. `mark 1` |
| Unmark | `unmark TASK_INDEX` <br> e.g. `unmark 2`|
| Delete | `delete TASK_INDEX` <br> e.g. `delete 0` |
| Find | `find KEYWORD` <br> e.g. `find report` |
| Help | `help` |
| Exit | `bye` |

## Collaboration
If you would like to work with me for future projects, you can drop me a follow on my socials and DM me! Let's connect!<br>
[LinkedIn](https://www.linkedin.com/in/vetrivel-karthikeyan/) |
[Email](mailto:vetrik10@gmail.com) |
[Github](https://github.com/vet3whale)