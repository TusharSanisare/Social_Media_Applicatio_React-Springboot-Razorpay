import React, { useState } from "react";
import { Button, Grid } from "@mui/material";
import { GoogleLogin } from "@react-oauth/google";
import AuthModal from "./AuthModel";

const Authentication = () => {
  const [openAuthModel, setOpenAuthModel] = useState(false);
  const handleOpenAuthModel = () => setOpenAuthModel(true);
  const handleCloseAuthModel = () => setOpenAuthModel(false);
  return (
    <div>
      <Grid className="overflow-y-hidden " container>
        <Grid className="hidden lg:block" item lg={7}>
          <img
            src="https://img.freepik.com/free-vector/gradient-monochrome-twitter-logo-template_52683-132643.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1724025600&semt=ais_hybrid"
            alt=""
            className="w-full h-screen"
          />
          <div className="absolute top-[26%] left-[19%]">
            {/* <svg
              xmlns="http://www.w3.org/2000/svg"
              x="0px"
              y="0px"
              width="100"
              height="100"
              viewBox="0 0 50 50"
              style="fill:#FFFFFF;"
            >
              <path d="M 11 4 C 7.1456661 4 4 7.1456661 4 11 L 4 39 C 4 42.854334 7.1456661 46 11 46 L 39 46 C 42.854334 46 46 42.854334 46 39 L 46 11 C 46 7.1456661 42.854334 4 39 4 L 11 4 z M 11 6 L 39 6 C 41.773666 6 44 8.2263339 44 11 L 44 39 C 44 41.773666 41.773666 44 39 44 L 11 44 C 8.2263339 44 6 41.773666 6 39 L 6 11 C 6 8.2263339 8.2263339 6 11 6 z M 13.085938 13 L 22.308594 26.103516 L 13 37 L 15.5 37 L 23.4375 27.707031 L 29.976562 37 L 37.914062 37 L 27.789062 22.613281 L 36 13 L 33.5 13 L 26.660156 21.009766 L 21.023438 13 L 13.085938 13 z M 16.914062 15 L 19.978516 15 L 34.085938 35 L 31.021484 35 L 16.914062 15 z"></path>
            </svg> */}
          </div>
        </Grid>
        <Grid className="px-10 mt-10" lg={5} xs={12}>
          <h1 className="font-bold text-5xl">Happening Now</h1>
          <h1 className="font-bold text-2xl mt-10 pb-3">Join Twitter Today</h1>
          <div className="w-[70%]">
            <div className="w-full">
              <GoogleLogin width={"100%"} />
              <p className="py-3 text-center">OR</p>
              <Button
                onClick={handleOpenAuthModel}
                fullWidth
                variant="contained"
                size="large"
                sx={{
                  borderRadius: "29px",
                  py: "7px",
                }}
              >
                Create Account
              </Button>
              <p className="text-sm mt-1">
                By signing up, you agree to the Terms of Service and Policy,
                including Cookie Use.
              </p>
            </div>
            <div className="mt-12">
              <h1 className="font-bold text-xl mb-3">Already Have Account?</h1>
              <Button
                onClick={handleOpenAuthModel}
                fullWidth
                variant="outlined"
                size="large"
                sx={{
                  borderRadius: "29px",
                  py: "7px",
                }}
              >
                LOGIN
              </Button>
            </div>
          </div>
        </Grid>
      </Grid>
      <AuthModal open={openAuthModel} handleClose={handleCloseAuthModel} />
    </div>
  );
};

export default Authentication;
