import React from 'react';
import { BrowserRouter,Routes, Route } from 'react-router-dom';
import './App.css';

import { Authentication } from './pages/Authentication/Authentication';
import HomePage from './HomePage/HomePage';
import Message from './Message/Message';

function App() {
  return (
    <div className="">
      <BrowserRouter>

      <Routes>
        <Route path='/*' element={<HomePage />} />
        <Route path='/message' element={<Message />} />
        <Route path='/*' element={<Authentication />} />
      </Routes>

      </BrowserRouter>
    </div>
  );
}

export default App;
