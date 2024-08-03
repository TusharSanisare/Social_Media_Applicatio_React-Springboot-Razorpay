import React, { useState } from "react";
import SearchIcon from "@mui/icons-material/Search";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import Brightness6Icon from "@mui/icons-material/Brightness6";
import { Button } from "@mui/material";
import SubscriptionModel from "../SubscriptionModel/SubscriptionModel";

const RightPart = () => {
  const [openSubscriptionModel, setOpenSubscriptionModel] = useState(false);
  const handleOpen = () => setOpenSubscriptionModel(true);
  const handleClose = () => setOpenSubscriptionModel(false);

  const handleChangeTheme = () => {
    console.log("handleChangeTheme");
  };
  return (
    <div className="py-5 sticky top">
      <div className="relative flex items-center">
        <input
          type="text"
          className="py-3 rounded-full text-gray-500 w-full pl-12"
        />
        <div className="absolute top-0 left-0 pl-3 pt-3">
          <SearchIcon className="text-gray-500 " />
        </div>
        <Brightness6Icon
          className="ml-3 cursor-pointer"
          onClick={handleChangeTheme}
        />
      </div>
      <section className="my-5 ">
        <h1 className="text-xl font-bold ">Get Verified </h1>
        <h1 className="font-bold my-2">Sebscride to unlock new Features</h1>
        <Button
          onClick={handleOpen}
          variant="contained"
          sx={{ padding: "10px", paddingX: "20px", borderRadius: "25px" }}
        >
          Get Verified
        </Button>
      </section>
      <section className="mt-7 space-y-5">
        <h1 className="font-bold text-xl py-1 ">What's happening </h1>
        <div className="">
          <p className="text-sm">Read adout IND vs SL test series . LIVE</p>
          <p className="font-bold">
            India VS Shrilanka is now live on jio cenama watch for free now
          </p>
        </div>
        {[1, 1, 1, 1].map((item) => (
          <div className="flex justify-between w-full">
            <div className="">
              <p>Entertainment . Trending</p>
              <p className="font-bold">
                India VS Shrilanka is now live on jio cenama watch for free now
              </p>
              <p>34.5k tweets</p>
            </div>
            <MoreHorizIcon />
          </div>
        ))}
      </section>
      <section>
        <SubscriptionModel
          open={openSubscriptionModel}
          handleClose={handleClose}
        />
      </section>
    </div>
  );
};

export default RightPart;
