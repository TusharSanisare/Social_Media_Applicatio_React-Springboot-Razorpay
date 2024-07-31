import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import TweetCard from "../HomeSection/TweetCard";
import { Divider } from "@mui/material";

const TwitDetails = () => {
  const navigate = useNavigate();
  const handleBack = () => {
    navigate(-1);
  };
  return (
    <React.Fragment>
      <section
        className={` bg-white z-50 flex items-center sticky top-0 bg-opacity-95`}
      >
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-95 ml-5">Tweet</h1>
      </section>
      <section className="">
        <TweetCard />
        <Divider sx={{ margin: "2rem 0rem" }} />
      </section>
      <section>
        {[1, 1, 1, 1].map((item) => (
          <TweetCard />
        ))}
      </section>
    </React.Fragment>
  );
};

export default TwitDetails;
