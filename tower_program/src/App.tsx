import { useState } from "react";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
type TowerDataDTO = {
  documentType: string;
  siteType: string;
  srType: string;
  btsType: string;
  tmType: string;
  mwHeight?: number;
  mwAzimuth?: number;
};
const SERVER_URL =
  process.env.NODE_ENV === "development" ? "http://localhost:7000" : "";
function App() {
  const [documentType, setDocumentType] = useState("Site_Agreement_Copy");
  const [siteType, setSiteType] = useState("GBT");
  const [srType, setSRType] = useState("Urban");
  const [btsType, setBTSType] = useState("Indoor");
  const [tmType, setTMType] = useState("MW");
  const [mwHeight, setMWHeight] = useState(0);
  const [mwAzimuth, setMWAzimuth] = useState(0);
  const [selectedFile, setSelectedFile] = useState({} as File);
  const cssOptions = {};
  const [apiResponse, setApiResponse] = useState({});
  const handleSubmit = async () => {
    const theDto: TowerDataDTO = {
      btsType,
      documentType,
      siteType,
      srType,
      tmType,
      mwAzimuth,
      mwHeight,
    };
    const formData = Object.keys(theDto).reduce((formData, key) => {
      formData.append(key, (theDto as any)[key]);
      return formData;
    }, new FormData());
    formData.append("file", selectedFile);
    formData.append("id", Math.floor(Math.random() * 99999).toString());
    // Sending the Data

    setApiResponse(
      await (
        await fetch(`${SERVER_URL}/thePostEndpoint`, {
          method: "POST",
          body: formData,
        })
      ).json()
    );
    console.log(apiResponse);
  };

  return (
    <>
      <div style={{ display: "flex", justifyContent: "center" }}>
        <form
          encType="multipart/form-data"
          onSubmit={(e) => {
            e.preventDefault();
            handleSubmit();
          }}
        >
          <label
            htmlFor="document_type"
            className="row m-auto"
            style={cssOptions}
          >
            Document To Upload
          </label>
          <select
            required
            name="document_type"
            id="document_type"
            className="row m-auto p-4 "
            style={cssOptions}
            onChange={(e: any) => setDocumentType(e.target.value)}
          >
            <option value="Site_Agreement_Copy">Site Agreement Copy</option>
            <option value="Electricity_Bill">Electricity Bill</option>
            <option value="NOC_Form">NOC Form Co-Owners</option>
            <option value="Municipal_Permission">Municipal Permission</option>
          </select>

          <label htmlFor="file" style={cssOptions} className="row m-auto">
            <b>Upload {documentType}</b>
          </label>
          <input
            required
            type="file"
            id="file"
            name="document_file"
            className="row m-auto"
            style={cssOptions}
            onChange={(e) => {
              setSelectedFile(e.target.files![0]);
            }}
          />
          <label htmlFor="SiteType">Site Type</label>
          <select
            name="SiteType"
            id="SiteType"
            onChange={({ target: { value } }) => setSiteType(value)}
          >
            <option value="GBT">GBT</option>
            <option value="RTT">RTT</option>
            <option value="RTP">RTP</option>
            <option value="COW">COW</option>
          </select>
          <label htmlFor="SRType">SR Type</label>
          <select
            required
            name="SRType"
            id="SRType"
            onChange={({ target: { value } }) => setSRType(value)}
          >
            <option value="Urban">Urban</option>
            <option value="Rural">Rural</option>
            <option value="Semi-Urban">Semi-Urban</option>
          </select>
          <label htmlFor="BTSType">BTS Type</label>
          <select
            required
            name="BTSType"
            id="BTSType"
            onChange={({ target: { value } }) => setBTSType(value)}
          >
            <option value="Indoor">Indoor</option>
            <option value="Outdoor">Outdoor</option>
            <option value="Split">Split</option>
          </select>
          <label htmlFor="TMType">Transmission Type</label>
          <select
            required
            name="TMType"
            id="TMType"
            onChange={({ target: { value } }) => {
              setTMType(value);
              if (value === "Fiber") setMWAzimuth(-1);
              setMWHeight(-1);
            }}
          >
            <option value="MW">MW</option>
            <option value="Fiber">Fiber</option>
          </select>
          {(() => {
            if (tmType === "MW")
              return (
                <div>
                  <b>MW Details </b>
                  <>
                    <label htmlFor="MWHeight">Height of MW</label>
                    <input
                      required
                      type="number"
                      name="MWHeight"
                      id="MWHeight"
                    
                      onChange={({ target: { value } }) => setMWHeight(+value)}
                    />
                    <label htmlFor="MWAzimuth">Azimuth of MW</label>
                    <input
                      required
                      type="number"
                      name="MWAzimuth"
                      id="MWAzimuth"
                      
                      onChange={({ target: { value } }) => setMWAzimuth(+value)}
                    />
                  </>
                </div>
              );
          })()}
          <button className="btn btn-primary" type="submit">
            Submit Details
          </button>
        </form>
      </div>

      {Object.keys(apiResponse).length !== 0 ? (
        <>
          <h1>Response From API</h1>
          {Object.keys(apiResponse).map((key, idx) => {
            return (
              <>
                <li key={idx}>
                  {key}: {(apiResponse as any)[key]}
                </li>
              </>
            );
          })}{" "}
        </>
      ) : (
        <></>
      )}
    </>
  );
}

export default App;
