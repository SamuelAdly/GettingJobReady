import { Brain } from 'lucide-react';
export default function Navbar() {
    return (
    <nav className="sticky top-0 z-50 border-b border-gray-100 bg-white/80 backdrop-blur-sm">
        <div className="px-6 mx-auto max-w-7xl lg:px-8">
            <div className="flex items-center justify-between h-16">
            <div className="flex items-center space-x-3">
                <div className="flex items-center justify-center w-8 h-8 rounded-lg bg-gradient-to-r from-blue-600 to-purple-600">
                <Brain className="w-5 h-5 text-white" />
                </div>
                <span className="text-xl font-semibold text-gray-900">StudyBuddies</span>
            </div>
            <div className="items-center hidden space-x-8 md:flex">
                <a href="#features" className="text-gray-600 hover:text-gray-900">Features</a>
                <a href="#how-it-works" className="text-gray-600 hover:text-gray-900">How it works</a>
                <a href="#pricing" className="text-gray-600 hover:text-gray-900">Pricing</a>
                <a className="text-gray-600 hover:text-gray-900" href='/signin'>Sign in</a>
                <a className='px-4 py-2 text-white bg-blue-600 rounded-lg hover:bg-blue-700' href='/signup'>Get Started</a>
            </div>
            <div className='flex items-center space-x-2 md:hidden'>
                <a className="px-4 py-2 text-purple-600 transition duration-500 ease-out border-2 border-purple-600 rounded-lg hover:bg-purple-700 hover:text-white " href='/signin'>Sign in</a>
                <a className='px-4 py-2 text-blue-600 transition duration-500 ease-out border-2 border-blue-600 rounded-lg  hover:bg-blue-700 hover:text-white' href='/signup'>Get Started</a>
            </div>
            </div>
        </div>
    </nav>
    )
}