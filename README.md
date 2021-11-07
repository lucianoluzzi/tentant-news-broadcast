
## Architecture, tech-stack, choices and reasoning:

The project is multi-modular and, module creation was decided either by feature or by how reusable functionality is (things like navigation, shared design assets, or shared models).
This would allow better scaling of the project and even sharing code between apps.

I decided to use the classic MVVM architecture.
In the packages, you will see the separation between data, domain, and UI layers, but I chose to leave the UseCase pattern out, given there isn't much logic being done.

In the message details screen, I used sealed classes to define the group of actions that can be done, interacting with the ViewModel through this single entry point.
Likewise, I defined groups of events that can take place on that screen and exposed it to the screen as a single source of effects.
If that screen had multiple states, I would do something similar and expose it through another LiveData or Flow.

## What could be improved
There is a duplication happening in the list, probably something related to the page key.

When the user marks a message as "interested in" and comes back to the list, the icon doesn't reflect the new state.
I would fix this by storing local data, which would make the app more responsive and would allow for offline usage.

Missing unit tests, given that implementing it would make the assignment take a lot more time than 2-3 hours.
