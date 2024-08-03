import React, { useState } from "react";
import RepeatIcon from "@mui/icons-material/Repeat";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FavoriteIcon from "@mui/icons-material/Favorite";
import BarChartIcon from "@mui/icons-material/BarChart";
import { Avatar, Button, Menu, MenuItem } from "@mui/material";
import { useNavigate } from "react-router-dom";
import ReplyModal from "./ReplyModal";

const TweetCard = () => {
  const navigate = useNavigate();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const [openReplyModel, setOpenReplyModel] = useState(false);
  const handleOpenReplyModel = () => setOpenReplyModel(true);
  const handleCloseReplyModel = () => setOpenReplyModel(false);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const handleDeleteTweet = () => {
    console.log("delete tweet");
    handleClose();
  };

  const handleCreateRetweet = () => {
    console.log("handle Create Retweet");
  };
  const handleLikeTweet = () => {
    console.log("handle Like Tweet");
  };
  return (
    <React.Fragment>
      {/* <div className="flex items-center font-semibold text-gray-700 py-2">
        <RepeatIcon />
        <p>You Retweet</p>
      </div> */}
      <div className="flex space-x-5">
        <Avatar
          onClick={() => navigate("/profile/${6}")}
          className="cursor-pointer"
          src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png"
        />
        <div className="w-full ">
          <div className="flex justify-between items-center">
            <div className="flex cursor-pointer items-center space-x-2">
              <span className="font-semibold">Code with tusras</span>
              <span className="text-gray-600">@tuhasgjd . 2m</span>
              <img
                className="ml-2 w-7 h-7"
                src="https://png.pngtree.com/png-vector/20230824/ourmid/pngtree-a-logo-that-has-been-verified-in-blue-with-scrible-effect-vector-png-image_9198134.png"
              />
            </div>
            <div className="">
              <Button
                id="basic-button"
                aria-controls={open ? "basic-menu" : undefined}
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleClick}
              >
                <MoreHorizIcon />
              </Button>
              <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                MenuListProps={{
                  "aria-labelledby": "basic-button",
                }}
              >
                <MenuItem onClick={handleDeleteTweet}>Delete</MenuItem>
                <MenuItem onClick={handleDeleteTweet}>Edit</MenuItem>
              </Menu>
            </div>
          </div>
          <div className="mt-2">
            <div
              onClick={() => navigate("twit/{3}")}
              className="cursor-pointer"
            >
              <p className="mb-2 p-0">nice babejkasanakfn qenf qefn qwfwtg8b</p>
              <img
                className="w-[28rem] border border-gray-400 p-5 rounded-md"
                src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png"
                alt=""
              />
            </div>
            <div className="py-5 flex flex-wrap justify-between items-center">
              <div className="space-x-3 flex items-center text-gray-600">
                <ChatBubbleOutlineIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModel}
                />
                <p>43</p>
              </div>
              <div
                className={`${
                  true ? "text-pink-600" : "text-gray-600"
                } space-x-3 flex items-center`}
              >
                <RepeatIcon
                  className="cursor-pointer"
                  onClick={handleCreateRetweet}
                />
                <p>54</p>
              </div>
              <div
                className={`${
                  true ? "text-pink-600" : "text-gray-600"
                } space-x-3 flex items-center`}
              >
                {true ? (
                  <FavoriteIcon
                    className="cursor-pointer"
                    onClick={handleLikeTweet}
                  />
                ) : (
                  <FavoriteBorderIcon
                    className="cursor-pointer"
                    onClick={handleLikeTweet}
                  />
                )}
                <p>54</p>
              </div>
              <div className="space-x-3 flex items-center text-gray-600">
                <BarChartIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModel}
                />
                <p>43</p>
              </div>
              <div className="space-x-3 flex items-center text-gray-600">
                <FileUploadIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModel}
                />
              </div>
            </div>
          </div>
        </div>
      </div>
      <section>
        <ReplyModal open={openReplyModel} handleClose={handleCloseReplyModel} />
      </section>
    </React.Fragment>
  );
};

export default TweetCard;
