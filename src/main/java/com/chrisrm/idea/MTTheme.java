/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Chris Magnussen and Elior Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.chrisrm.idea;

import com.chrisrm.idea.themes.LafTheme;
import com.chrisrm.idea.utils.PropertiesParser;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.JBColor;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public abstract class MTTheme implements LafTheme {
  private final String id;
  private final String editorColorsScheme;
  private final boolean dark;

  protected MTTheme(@NotNull final String id, @NotNull final String editorColorsScheme, final boolean dark) {
    this.id = id;
    this.editorColorsScheme = editorColorsScheme;
    this.dark = dark;
  }

  /**
   * Get disabled color
   *
   * @return
   */
  @Override
  public String getDisabled() {
    return null;
  }

  @Override
  public final void activate() {
    try {
      UIManager.setLookAndFeel(new MTLaf(this));
      JBColor.setDark(this.isDark());
      IconLoader.setUseDarkIcons(this.isDark());


      buildResources(getBackgroundResources(), getBackgroundColorString());
      buildResources(getForegroundResources(), getForegroundColorString());
      buildResources(getTextResources(), getTextColorString());
      buildResources(getSelectionBackgroundResources(), getSelectionBackgroundColorString());
      buildResources(getSelectionForegroundResources(), getSelectionForegroundColorString());
      buildResources(getInactiveResources(), getInactiveColorString());
      buildResources(getCaretResources(), getCaretColorString());
      buildResources(getSecondaryBackgroundResources(), getSecondaryBackgroundColorString());
      buildResources(getDisabledResources(), getDisabledColorString());
      buildResources(getContrastResources(), getContrastColorString());
      buildResources(getTableSelectedResources(), getTableSelectedColorString());
      buildResources(getSecondBorderResources(), getSecondBorderColorString());
      buildResources(getHighlightResources(), getHighlightColor());

      buildResources(getButtonHighlightResources(), getButtonHighlightColorString());
      buildResources(getTreeSelectionResources(), getTreeSelectionColorString());

    } catch (final UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  protected abstract String getTreeSelectionColorString();

  protected abstract String getButtonHighlightColorString();

  protected abstract String getHighlightColor();

  protected abstract String getSecondBorderColorString();

  protected abstract String getTableSelectedColorString();

  protected abstract String getContrastColorString();

  protected abstract String getDisabledColorString();

  protected abstract String getSecondaryBackgroundColorString();

  protected abstract String getCaretColorString();

  protected abstract String getInactiveColorString();

  protected abstract String getSelectionForegroundColorString();

  protected abstract String getSelectionBackgroundColorString();

  protected abstract String getTextColorString();

  protected abstract String getForegroundColorString();

  protected abstract String getBackgroundColorString();

  protected String[] getTreeSelectionResources() {
    return new String[]{
        "Tree.selectionBackground"
    };
  }

  protected String[] getButtonHighlightResources() {
    return new String[]{
        "Button.mt.color2",
        "Button.mt.selection.color2"
    };
  }

  protected String[] getHighlightResources() {
    return new String[]{
        "Focus.color",
        "TextField.separatorColor",
        "ProgressBar.halfColor",
        "CheckBox.darcula.inactiveFillColor",
        "MemoryIndicator.usedColor"
    };
  }

  protected String[] getSecondBorderResources() {
    return new String[]{
        "MenuBar.darcula.borderShadowColor",
        "CheckBox.darcula.disabledBorderColor1",
        "CheckBox.darcula.disabledBorderColor2"
    };
  }

  protected String[] getTableSelectedResources() {
    return new String[]{
        "Table.selectionBackground",
        "TextField.selectionBackground",
        "PasswordField.selectionBackground",
        "Button.darcula.selection.color1",
        "Button.darcula.selection.color2",
        "Button.mt.selection.color1",
        "MemoryIndicator.unusedColor"
    };
  }

  protected String[] getContrastResources() {
    return new String[]{
        "Table.stripedBackground",
        "material.contrast"
    };
  }

  protected String[] getDisabledResources() {
    return new String[]{
        "MenuItem.disabledForeground",
        "TextField.inactiveForeground",
        "PasswordField.inactiveForeground",
        "Button.disabledText",
        "CheckBox.darcula.checkSignColorDisabled"
    };
  }

  protected String[] getSecondaryBackgroundResources() {
    return new String[]{
        "inactiveCaption",
        "List.background"
    };
  }

  protected String[] getCaretResources() {
    return new String[]{
        "mt.default.caretForeground"
    };
  }

  protected String[] getInactiveResources() {
    return new String[]{
        "MenuBar.darcula.borderColor",
        "MenuBar.darcula.borderShadowColor",
        "Separator.foreground",
        "Button.mt.color1",
        "Button.mt.background",
        "material.disabled",
        "material.mergeCommits"
    };
  }

  protected String[] getSelectionForegroundResources() {
    return new String[]{
        "mt.default.selectionForeground",
        "Menu.selectionForeground",
        "Menu.acceleratorSelectionForeground",
        "MenuItem.selectionForeground",
        "MenuItem.acceleratorSelectionForeground",
        "Table.selectionForeground",
        "TextField.selectionForeground",
        "PasswordField.selectionForeground",
        "Button.mt.selectedForeground",
        "TextArea.selectionForeground",
        "Button.darcula.selectedButtonForeground"
    };
  }

  protected String[] getSelectionBackgroundResources() {
    return new String[]{
        "mt.default.selectionBackgroundInactive",
        "mt.default.selectionInactiveBackground",
        "Menu.selectionBackground",
        "MenuItem.selectionBackground",
        "Autocomplete.selectionbackground",
        "EditorPane.inactiveForeground",
        "ScrollBar.thumb"
    };
  }

  protected String[] getTextResources() {
    return new String[]{
        "Menu.acceleratorForeground",
        "MenuItem.acceleratorForeground",
        "TextField.separatorColorDisabled",
        "ComboBox.disabledForeground",
        "Button.foreground",
        "Button.mt.foreground",
        "Tree.foreground"
    };
  }

  protected String[] getBackgroundResources() {
    return new String[]{
        "mt.default.background",
        "mt.default.textBackground",
        "mt.default.inactiveBackground",
        "window",
        "activeCaption",
        "control",
        "PopupMenu.translucentBackground",
        "EditorPane.inactiveBackground",
        "Table.background",
        "Table.gridColor",
        "MenuBar.disabledBackground",
        "MenuBar.shadow",
        "TabbedPane.highlight",
        "TabbedPane.darkShadow",
        "TabbedPane.shadow",
        "TabbedPane.borderColor",
        "TextField.background",
        "PasswordField.background",
        "FormattedTextField.background",
        "TextArea.background",
        "CheckBox.darcula.backgroundColor1",
        "CheckBox.darcula.backgroundColor2",
        "CheckBox.darcula.checkSignColor",
        "CheckBox.darcula.shadowColor",
        "CheckBox.darcula.shadowColorDisabled",
        "CheckBox.darcula.focusedArmed.backgroundColor1",
        "CheckBox.darcula.focusedArmed.backgroundColor2",
        "CheckBox.darcula.focused.backgroundColor1",
        "CheckBox.darcula.focused.backgroundColor2",
        "ComboBox.background",
        "ComboBox.disabledBackground",
        "ComboBox.arrowFillColor",
        "RadioButton.darcula.selectionDisabledColor",
        "StatusBar.topColor",
        "StatusBar.top2Color",
        "StatusBar.bottomColor",
        "Button.background",
        "Button.darcula.color1",
        "Button.darcula.color2",
        "Button.darcula.disabledText.shadow",
        "ToolTip.background",
        "Spinner.background",
        "SplitPane.highlight",
        "Panel.background",
        "SidePanel.background",
        "DialogWrapper.southPanelDivider",
        "OnePixelDivider.background",
        "Dialog.titleColor",
        "material.tab.backgroundColor"
    };
  }

  protected String[] getForegroundResources() {
    return new String[]{
        "mt.default.foreground",
        "mt.default.textForeground",
        "mt.default.selectionForegroundInactive",
        "mt.default.selectionInactiveForeground",
        "text",
        "textText",
        "textInactiveText",
        "infoText",
        "controlText",
        "OptionPane.messageForeground",
        "Menu.foreground",
        "MenuItem.foreground",
        "EditorPane.inactiveForeground",
        "Table.sortIconColor",
        "TitledBorder.titleColor"
    };
  }


  /**
   * Get tree indent
   *
   * @return
   */
  public int getTreeIndent() {
    return ObjectUtils.notNull(UIManager.getInt("Tree.rightChildIndent"), 6);
  }

  /**
   * Get background color custom property
   */
  @NotNull
  public Color getBackgroundColor() {
    return ObjectUtils.notNull(UIManager.getColor("material.tab.backgroundColor"), new ColorUIResource(0x263238));
  }

  /**
   * Get border color custom property
   */
  @NotNull
  public Color getBorderColor() {
    return ObjectUtils.notNull(UIManager.getColor("material.tab.borderColor"), new ColorUIResource(0x80cbc4));
  }

  /**
   * Get border thickness custom property
   */
  public int getBorderThickness() {
    return ObjectUtils.notNull(UIManager.getInt("material.tab.borderThickness"), 2);
  }

  /**
   * Get contrast color custom property
   */
  @NotNull
  public Color getContrastColor() {
    return ObjectUtils.notNull(UIManager.getColor("material.contrast"), new ColorUIResource(0x1E272C));
  }

  @NotNull
  public final String getEditorColorsScheme() {
    return editorColorsScheme;
  }

  public final boolean isDark() {
    return dark;
  }

  @NotNull
  public final String getId() {
    return id;
  }

  private void buildResources(final String[] resources, final String color) {
    for (final String resource : resources) {
      UIManager.put(resource, PropertiesParser.parseColor(color));
    }
  }

}
