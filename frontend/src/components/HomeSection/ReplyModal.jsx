import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import { Avatar } from "@mui/material";
import { useNavigate } from "react-router-dom";
import ImageIcon from "@mui/icons-material/Image";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import TagFacesIcon from "@mui/icons-material/TagFaces";
import { useFormik } from "formik";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  outline: "none",
  borderRadius: "4px",
  boxShadow: 24,
  p: 4,
};

export default function ReplyModal({ handleClose, open }) {
  const navigate = useNavigate();
  const [uploadingImage, setUploadingImage] = useState(false);
  const [selectedImage, setSelectedImage] = useState("");

  const handleSubmit = (values) => {
    console.log("hanjdfkw", values);
  };
  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
      twitId: 4,
    },
    onSubmit: handleSubmit,
  });

  const handleSelectImage = (event) => {
    setUploadingImage(true);
    const imgUrl = event.target.files[0];
    formik.setFieldValue("image", imgUrl);
    setSelectedImage(imgUrl);
    setUploadingImage(false);
  };

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
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
              </div>
              <div className="mt-2">
                <div
                  onClick={() => navigate("twit/{3}")}
                  className="cursor-pointer"
                >
                  <p className="mb-2 p-0">
                    nice babejkasanakfn qenf qefn qwfwtg8b
                  </p>
                </div>
              </div>
            </div>
          </div>
          <section className="py-10 ">
            <div className="flex space-x-5">
              <Avatar src="https://cdn-icons-png.flaticon.com/512/6596/6596121.png"></Avatar>
              <div className="w-full">
                <form onSubmit={formik.handleSubmit}>
                  <div>
                    <input
                      type="text"
                      name="content"
                      placeholder="What is happening"
                      className="border-none outline-none texl-xl bg-transparent"
                      {...formik.getFieldProps("content")}
                    />
                    {formik.errors.content && formik.touched.content && (
                      <span className="text-red-500">
                        {formik.errors.content}
                      </span>
                    )}
                  </div>
                  {/* <div className="">
                <img src="" alt="" />
              </div> */}
                  <div className="flex justify-between items-center mt-5">
                    <div className="flex space-x-5 items-center">
                      <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                        <ImageIcon className="text-[#1d9bf0]" />
                        <input
                          type="file"
                          name="imageFile"
                          className="hidden"
                          onChange={handleSelectImage}
                        />
                      </label>
                      <FmdGoodIcon className="text-[#1d9bf0]" />
                      <TagFacesIcon className="text-[#1d9bf0]" />
                    </div>
                    <div className="">
                      <Button
                        sx={{
                          width: "100%",
                          borderRadius: "20px",
                          paddingY: "8px",
                          paddingX: "20px",
                          bgcolor: "#1d9bf0",
                        }}
                        variant="contained"
                        type="submit"
                      >
                        Tweet
                      </Button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </section>
        </Box>
      </Modal>
    </div>
  );
}
