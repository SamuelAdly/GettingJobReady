import Image from "next/image";

export default function Home() {
  return (
    <main className="min-h-screen flex flex-col items-center justify-center px-2  bg-gray-900 text-white">
      <div className="border-2 p-6 rounded-2xl max-w-3xl w-full bg-gray-800">
        <h1 className="text-center text-2xl font-extrabold">Welcome to My Project Home Page</h1>
        <p className="text-center pb-4 text-md italic">Through these projects I am going to relearn Fullstack Development</p>

        <li><a className="font-bold text-lg hover:underline" href="/projects/project-0">HTML+CSS/Tailwind Recap</a>
        <p className="italic text-sm">Project 0: Relearning HTML+CSS</p></li>

        <li><a className="font-bold text-lg hover:underline" href="/projects/project-1">DevTasks - Task Manager App</a>
        <p className="italic text-sm">Project 1: Learning React Hooks, Components, Props, etc</p></li>

        <li><a className="font-bold text-lg hover:underline" href="/projects/project-2">StudyHub - Fullstack Course Tracker</a>
        <p className="italic text-sm">Project 2: Relearning Fullstack Development</p></li>

        <li><a className="font-bold text-lg hover:underline" href="/projects/project-3">DevLink - Developer Portfolio CMS</a>
        <p className="italic text-sm">Project 3: Relearn backend API`s, forms, file upload, and full CRUD admin</p></li>

      </div>
    </main>
  );
}
