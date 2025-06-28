import { Brain } from 'lucide-react';
export default function Navbar() {
    return (
    <nav className="border-b border-gray-100 bg-white/80 backdrop-blur-sm sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-6 lg:px-8">
            <div className="flex justify-between items-center h-16">
            <div className="flex items-center space-x-3">
                <div className="w-8 h-8 bg-gradient-to-r from-blue-600 to-purple-600 rounded-lg flex items-center justify-center">
                <Brain className="w-5 h-5 text-white" />
                </div>
                <span className="text-xl font-semibold text-gray-900">StudyBuddies</span>
            </div>
            <div className="hidden md:flex items-center space-x-8">
                <a href="#features" className="text-gray-600 hover:text-gray-900">Features</a>
                <a href="#how-it-works" className="text-gray-600 hover:text-gray-900">How it works</a>
                <a href="#pricing" className="text-gray-600 hover:text-gray-900">Pricing</a>
                <a className="text-gray-600 hover:text-gray-900" href='/signin'>Sign in</a>
                <a className='bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700' href='/signup'>Get Started</a>
            </div>
            <div className='md:hidden flex items-center space-x-2'>
                <a className="text-purple-600 border-2 px-4 py-2 rounded-lg border-purple-600 hover:bg-purple-700 hover:text-white transition ease-out duration-500 " href='/signin'>Sign in</a>
                <a className=' text-blue-600 px-4 py-2 border-2 border-blue-600 rounded-lg hover:bg-blue-700 hover:text-white transition ease-out duration-500' href='/signup'>Get Started</a>
            </div>
            </div>
        </div>
    </nav>
    )
}