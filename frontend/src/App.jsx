import React from "react";
import { Route, Routes } from "react-router-dom";
import HomePage from "./components/HomePage/HomePage";
import Authentication from "./components/Authentication/Authentication";

const App = () => {
  return (
    <div>
      <Routes>
        <Route
          path="/*"
          element={true ? <HomePage /> : <Authentication />}
        ></Route>
      </Routes>
    </div>
  );
};

export default App;
