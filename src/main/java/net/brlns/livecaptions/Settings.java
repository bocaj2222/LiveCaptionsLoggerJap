/*
 * Copyright (C) 2024 hstr0100
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.brlns.livecaptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Program Settings
 *
 * @author Gabriel / hstr0100 / vertx010
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Settings {

    /**
     * Screen coordinates for the live captions
     *
     * Ships with default settings for 1080p at 125% scale
     * If you have a different resolution make sure
     * to configure the capture area via the system tray menu.
     */
    @JsonProperty("PixelStartX")
    private int boxStartX = 15;
    @JsonProperty("PixelStartY")
    private int boxStartY = 15;

    @JsonProperty("PixelEndX")
    private int boxEndX = 1795;
    @JsonProperty("PixelEndY")
    private int boxEndY = 103;

    /**
     * Output directory for logs and debug images.
     */
    @JsonProperty("OutputPath")
    private String outputPath = "";

    /**
     * If you are exclusively using this program with Windows 11's Live Captions,
     * this setting enables you to determine whether to automatically toggle
     * logging on or off when Live Captions is running.
     */
    @JsonProperty("LiveCaptionsSensing")
    private boolean liveCaptionsSensing = false;

    /**
     * This option should be set to true if you're trying to capture anything
     * else that is not Windows 11's LiveCaptions with theme set to white on black.
     */
    @JsonProperty("CaptureAnyText")
    private boolean captureAnyText = false;

    /**
     * Improves Tesseract's readability when dealing with white text on dynamic
     * backgrounds
     * e.g youtube's closed captions
     *
     * if CaptureAnyText is set true this should probably also be set to true.
     */
    @JsonProperty("ContrastMode")
    private boolean contrastMode = false;

    /**
     * If true, outputs debugging information to the console when started via cmd,
     * Also outputs debug images to OutputPath showing the current capture area.
     */
    @JsonProperty("DebugMode")
    private boolean debugMode = false;

    /**
     * Current logging state during startup.
     */
    @JsonProperty("LogAtStartup")
    private boolean currentlyLogging = true;

    /**
     * If the lines being generated are very short, we may not be able
     * to capture it in time, if you run into this problem and has CPU power
     * to spare, lower this value, 500ms (half a second) should be plenty
     *
     * Accepted range 50ms ~ 2500ms.
     */
    @JsonProperty("CaptureRateMs")
    private int captureRateMs = 1000;

    /**
     * should be a value between 0-255
     * 255 is the same as CaptureAnyText = true
     * 30 makes sure only gray~black caption boxes will work with this program
     * this value is checked against the RGB components of the pixels around the four corners.
     *
     * This value is ignored if CaptureAnyText is set to true.
     */
    @JsonProperty("CaptionWindowDetectColorThreshold")
    private int captionWindowColorThreshold = 30;

    /**
     * If you need to use languages other than English,
     * download tesseract from https://github.com/UB-Mannheim/tesseract/wiki
     * and point this to your own tessdata folder,
     * Typically that would be C:\Program Files\Tesseract-OCR\tessdata.
     */
    @JsonProperty("CustomTessDataPath")
    private String customTessDataPath = "";

    /**
     * Available languages:
     * https://tesseract-ocr.github.io/tessdoc/Data-Files#data-files-for-version-400-november-29-2016
     * Only change this if your CustomTessDataPath contains the required
     * language training files.
     */
    @JsonProperty("TesseractLanguage")
    private String tessLanguage = "jpn";

}
