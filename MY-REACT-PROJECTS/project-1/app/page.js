import Image from "next/image";

export default function Home() {
  return (
    <main className="min-h-screen flex flex-col items-center justify-center">
      <div>
        <h1>Welcome to My Project Home Page</h1>
        <p>Through this project, I am going to relearn Fullstack Development</p>
        <li><a href="/projects/project-0">HTML+CSS/Tailwind Recap</a>
        <p>project 0: Relearning HTML+CSS</p></li>
        <li><a href="/projects/project-1">DevTasks - Task Manager App</a>
        <p>project 1: Learning React Hooks, Components, Props, etc</p></li>
        <li><a href="/projects/project-2">StudyHub - Fullstack Course Tracker</a>
        <p>project 2: Relearning Fullstack Development</p></li>
        <li><a href="/projects/project-3">DevLink - Developer Portfolio CMS</a>
        <p>project 3: Relearn backend API`s, forms, file upload, and full CRUD admin</p></li>
      </div>
    </main>
  );
}
