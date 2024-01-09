import React from "react";
import { Grid, Grow } from "@mui/material";
import { Routes, Route, useLocation } from "react-router-dom";
import MiddlePart from "../Components/MiddlePart/MiddlePart";
import CreateReelsForm from "../Components/Reels/CreateReelsForm";
import Reels from "../Components/Reels/Reels";
import Profile from "../pages/Authentication/Profile/Profile";
import HomeRight from "../Components/HomeRight.jsx/HomeRight";
import Sidebar from "../Components/Sidebar/Sidebar";

const HomePage = () => {
  const location = useLocation();

  return (
    <div className="px-20">
      <Grid container spacing={0}>
        <Grid item xs={0} lg={3}>
          <div className="sticky top-0">
            <Sidebar />
          </div>
        </Grid>

        <Grid
          item
          xs={12}
          lg={location.pathname === "/" ? 6 : 9}
          className="px-5 flex justify-center"
        >
          <Routes>
            <Route path="/" element={<MiddlePart />} />
            <Route path="/reels" element={<Reels />} />
            <Route path="/create-reels" element={<CreateReelsForm />} />
            <Route path="/profile/:id" element={<Profile />} />
          </Routes>
        </Grid>

        {location.pathname === "/" && (
          <Grid item lg={3} className="relative">
            <div className="stick top-0 w-full">
              <HomeRight />
            </div>
          </Grid>
        )}
      </Grid>
    </div>
  );
};

export default HomePage;
