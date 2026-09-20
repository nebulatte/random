MEDIA LIBRARY PROGRAM

Features:
  - Add Media
  - Delete Media
  - Display Media

Abstraction:
  - Media abstract class that defines the common characteristics of its subclasses (Book, DVD, Magazine)
  - Book, DVD, and Magazine have their own separate files as subclasses of Media, each with unique identifiers -- MediaType
  - Types of media (BOOK, DVD, MAGAZINE) are centralized in the enum file 'MediaType'

Encapsulation:
  - Each file has private fields with designated getters to access them

IMPORTANT Notes:
  - 'Utils' static class contains display and input validation utility methods that are publicly accessible
  - 'MediaManager' focuses on the flow of data regarding the media inventory and operations associated with it; It focuses on a single responsibility: data manipulation
  - 'Main' serves as the central hub by handling the user interface, compiling multiple classes, and methods that complete the program

What I learned from my previous programs that I am trying to implement now:
  - Each method and class needs to do only one thing. Eg: Display, Validation, and Data Handling
  - Objects obviously act as their intended real-life counterparts, but their inner workings need to follow the previous principle
  - Don't oversimplify and compile similar methods into a single class. Sometimes classes will benefit more from defining their own validation methods within them
  - Don't use a single validation method for every input; it follows DRY (Don't Repeat Yourself), but different parts of the code may require different handling of the input
