import React, { useState } from "react";
import { Avatar, Button } from "@mui/material";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import BusinessCenterIcon from "@mui/icons-material/BusinessCenter";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import { useNavigate } from "react-router-dom";
import Box from "@mui/material/Box";
import Tab from "@mui/material/Tab";
import TabContext from "@mui/lab/TabContext";
import TabList from "@mui/lab/TabList";
import TabPanel from "@mui/lab/TabPanel";
import TweetCard from "../HomeSection/TweetCard";
import ProfileModel from "./ProfileModel";

const Profile = () => {
  const [tabValue, setTabValue] = useState("1");
  const [openProfileModel, setOpenProfileModel] = useState(false);
  const handleOpenProfileModel = () => setOpenProfileModel(true);
  const handleClose = () => setOpenProfileModel(false);

  const handleTabChange = (events, newValue) => {
    setTabValue(newValue);
    if (newValue === 4) {
      console.log("tab 4");
    } else if (newValue === 1) {
      console.log("user twits");
    }
  };

  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };

  const handleFollowUser = () => {
    console.log("handle Follow User");
  };
  return (
    <div>
      <section
        className={`bg-white z-50 flex items-center sticky top-0 bg-opacity-95`}
      >
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-95 ml-5">Tusakdkjdha</h1>
      </section>
      <section>
        <img
          className="w-[100%] h-[15rem] object-cover"
          src="https://buffer.com/library/content/images/size/w1200/2023/10/free-images.jpg"
          alt=""
        />
      </section>
      <section className="pl-6">
        <div className="flex justify-between items-start mt-5 h-[5rem]">
          <Avatar
            className="transform -translate-y-24"
            src="https://photosnow.org/wp-content/uploads/2024/04/simple-cute-girl-pic_3.jpg"
            sx={{ width: "10rem", height: "10rem", border: "4px solid white" }}
          />
          {true ? (
            <Button
              onClick={handleOpenProfileModel}
              className=""
              variant="contained"
              sx={{ borderRadius: "20px" }}
            >
              Edit Profile
            </Button>
          ) : (
            <Button
              onClick={handleFollowUser}
              className=""
              variant="contained"
              sx={{ borderRadius: "20px" }}
            >
              {true ? "Follow" : "Unfollow"}
            </Button>
          )}
        </div>
        <div className="">
          <div className="flex items-center">
            <h1 className="font-bold text-lg">Tushar adhwq</h1>
            {true && (
              <img
                className="ml-2 w-7 h-7"
                src="https://png.pngtree.com/png-vector/20230824/ourmid/pngtree-a-logo-that-has-been-verified-in-blue-with-scrible-effect-vector-png-image_9198134.png"
              />
            )}
          </div>
          <h1 className="text-gray-500">@tusharjalkdjl</h1>
        </div>
        <div className="mt-2 space-y-3">
          <p>
            Lorem ipsum dolor sit amet consectetur Lorem ipsum dolor sit amet.
          </p>
          <div className="py-1 flex space-x-5">
            <div className="flex items-center text-gray-500">
              <BusinessCenterIcon />
              <p>Education</p>
            </div>
            <div className="flex items-center text-gray-500">
              <LocationOnIcon />
              <p>India</p>
            </div>
            <div className="flex items-center text-gray-500">
              <CalendarMonthIcon />
              <p>Joined Jun 2022</p>
            </div>
          </div>
          <div className="flex items-center space-x-5">
            <div className="flex items-center space-x-1 font-semibold">
              <span>390</span>
              <span className="text-gray-500">Following</span>
            </div>
            <div className="flex items-center space-x-1 font-semibold">
              <span>580</span>
              <span className="text-gray-500">Followers</span>
            </div>
          </div>
        </div>
      </section>
      <section className="py-5">
        <Box sx={{ width: "100%", typography: "body1" }}>
          <TabContext value={tabValue}>
            <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
              <TabList
                onChange={handleTabChange}
                aria-label="lab API tabs example"
              >
                <Tab label="Tweets" value="1" />
                <Tab label="Rplies" value="2" />
                <Tab label="Media" value="3" />
                <Tab label="Liks" value="4" />
              </TabList>
            </Box>
            <TabPanel value="1">
              {[1, 1, 1, 1, 1].map((item) => (
                <TweetCard />
              ))}
            </TabPanel>
            <TabPanel value="2">user replies</TabPanel>
            <TabPanel value="3">Medis</TabPanel>
            <TabPanel value="4">Liks</TabPanel>
          </TabContext>
        </Box>
      </section>

      <section>
        <ProfileModel handleClose={handleClose} open={openProfileModel} />
      </section>
    </div>
  );
};

export default Profile;
