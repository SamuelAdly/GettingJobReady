'use client';
import React, { useState } from "react";

export default function Home() {
  const [counter, setCounter] = useState(0);
  return (
    <div className="justify-center justify-items-center flex flex-col items-center h-screen">
      <p>Counter: {counter}</p>
      <div className="space-x-4">
        <button className="border-1 border-black rounded" onClick={() => setCounter(counter + 1)}>
        Increment
      </button>
      <button onClick={() => setCounter(counter - 1)}>
        Decrement
      </button>
      </div>
    </div>
  );
}
